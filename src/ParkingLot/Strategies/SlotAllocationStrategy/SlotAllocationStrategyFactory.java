package ParkingLot.Strategies.SlotAllocationStrategy;

import ParkingLot.Models.Enums.SlotAllocationStrategyType;

public class SlotAllocationStrategyFactory {

    public static SlotAllocationStrategy getSlotForType(SlotAllocationStrategyType slotAllocationStrategyType){

        if(slotAllocationStrategyType.equals(SlotAllocationStrategyType.RANDOM)){

            return new RandomSlotAllocationStrategy();
        }
        return null;

    }
}
