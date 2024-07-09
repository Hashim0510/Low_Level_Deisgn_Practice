package ParkingLot.Services;

import Exceptions.GateNotFoundException;
import ParkingLot.Models.Enums.SlotAllocationStrategyType;
import ParkingLot.Models.Enums.VehicleType;
import ParkingLot.Models.Gate;
import ParkingLot.Models.ParkingSlot;
import ParkingLot.Models.Ticket;
import ParkingLot.Models.Vehicle;
import ParkingLot.Repositories.GateRepository;
import ParkingLot.Repositories.ParkingLotRepository;
import ParkingLot.Repositories.TicketRepository;
import ParkingLot.Repositories.VehicleRepository;
import ParkingLot.Strategies.SlotAllocationStrategy.SlotAllocationStrategy;
import ParkingLot.Strategies.SlotAllocationStrategy.SlotAllocationStrategyFactory;

import java.util.Date;
import java.util.Optional;

public class TicketServices {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, long gateId) throws GateNotFoundException{

        /*

        1.  create a ticket
        2.  allot a slot to the vehicle
        3.  save the ticket
        4.  return the ticket to controller

         */

        Ticket ticket = new Ticket();

//        Vehicle vehicle = new Vehicle();
//        vehicle.setVehicleType(vehicleType);
//        vehicle.setVehicleNumber(vehicleNumber);
//
//        ticket.setVehicle(vehicle);

        ticket.setEntryTime(new Date());

        Optional<Gate> gateOptional  = gateRepository.findByGateId(gateId);

        if(gateOptional.isEmpty()){

            throw new GateNotFoundException();

        }

        Gate gate = gateOptional.get();
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());

        //allot a slot to vehicle

        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVehicleNumber(vehicleNumber);

        Vehicle savedVehicle = null;
        if(vehicleOptional.isEmpty()){

            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            savedVehicle = vehicleRepository.save(vehicle);

        }

        savedVehicle = vehicleOptional.get();

        ticket.setVehicle(savedVehicle);

        SlotAllocationStrategyType slotAllocationStrategyType = parkingLotRepository.getSlotAllocationStrategyType();

        SlotAllocationStrategy slotAllocationStrategy = SlotAllocationStrategyFactory.getSlotForType(slotAllocationStrategyType);

        ParkingSlot parkingSlot = slotAllocationStrategy.bookSlot(savedVehicle);

        ticket.setParkingSlot(parkingSlot);

        Ticket savedTicket = ticketRepository.save(ticket);

        ticket.setTicketNumber("ticketNumber - " + savedTicket.getId());

        return ticket;

    }
}
