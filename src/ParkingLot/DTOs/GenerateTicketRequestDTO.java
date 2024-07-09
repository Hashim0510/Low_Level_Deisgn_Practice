package ParkingLot.DTOs;

import ParkingLot.Models.Enums.VehicleType;
import ParkingLot.Models.Gate;

public class GenerateTicketRequestDTO {

    private String VehicleNumber;
    private VehicleType vehicleType;
    private long  gateId;

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public long getGateId() {
        return gateId;
    }

    public void setGateId(long gateId) {
        this.gateId = gateId;
    }
}
