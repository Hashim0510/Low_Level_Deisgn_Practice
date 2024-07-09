package ParkingLot.Models;

import ParkingLot.Models.Enums.FeeCalculationStrategyType;
import ParkingLot.Models.Enums.ParkingLotStatus;
import ParkingLot.Models.Enums.SlotAllocationStrategyType;
import ParkingLot.Models.Enums.VehicleType;

import java.util.List;

public class ParkingLot {

    private long id;
    private String address;
    private List<ParkingFloor> floors;
    private Gate entry;
    private Gate exit;
    private FeeCalculationStrategyType feeCalculationStrategyType;
    private SlotAllocationStrategyType slotAllocationStrategyType;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType> allowedVehicleTypes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public Gate getEntry() {
        return entry;
    }

    public void setEntry(Gate entry) {
        this.entry = entry;
    }

    public Gate getExit() {
        return exit;
    }

    public void setExit(Gate exit) {
        this.exit = exit;
    }

    public FeeCalculationStrategyType getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }

    public void setFeeCalculationStrategy(FeeCalculationStrategyType feeCalculationStrategyType) {
        this.feeCalculationStrategyType = feeCalculationStrategyType;
    }

    public SlotAllocationStrategyType getSlotAllocationStrategyType() {
        return slotAllocationStrategyType;
    }

    public void setSlotAllocationStrategyType(SlotAllocationStrategyType slotAllocationStrategyType) {
        this.slotAllocationStrategyType = slotAllocationStrategyType;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }
}
