package ParkingLot.Controllers;

import ParkingLot.DTOs.GenerateTicketRequestDTO;
import ParkingLot.DTOs.GenerateTicketResponseDTO;
import ParkingLot.DTOs.ResponseStatus;
import ParkingLot.Models.Ticket;
import ParkingLot.Services.TicketServices;

import java.security.CodeSigner;

public class TicketController {

    private TicketServices ticketServices;

    public GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO generateTicketRequestDTO){
        
        GenerateTicketResponseDTO generateTicketResponseDTO = new GenerateTicketResponseDTO();
        
        Ticket ticket = null;
        
        try{
            
            ticket = ticketServices.generateTicket(
                        generateTicketRequestDTO.getVehicleNumber(),
                        generateTicketRequestDTO.getVehicleType(),
                        generateTicketRequestDTO.getGateId()
            );
            
        }
        catch(Exception e){
            
            generateTicketResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            generateTicketResponseDTO.setMessage("generating ticket failed!!!");
            return generateTicketResponseDTO;
        }
        generateTicketResponseDTO.setTicket(ticket);
        generateTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        generateTicketResponseDTO.setMessage("success!!!");
        return generateTicketResponseDTO;

    }
}
