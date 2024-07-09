package ParkingLot.Strategies.SlotAllocationStrategy;

import ParkingLot.Models.Enums.SlotAllocationStrategyType;
import ParkingLot.Models.ParkingSlot;
import ParkingLot.Models.Vehicle;

public interface SlotAllocationStrategy {

    public ParkingSlot bookSlot(Vehicle vehicle);

}
