package ParkingLot.Models;

import ParkingLot.Models.Enums.ParkingSlotStatus;
import ParkingLot.Models.Enums.VehicleType;

public class ParkingSlot {

    private long id;
    private String slotNumber;
    private VehicleType vehicleType;
    private ParkingSlotStatus parkingSlotStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }
}
