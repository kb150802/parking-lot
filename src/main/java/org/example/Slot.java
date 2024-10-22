package org.example;

public class Slot {
    private final VehicleType vehicleType;
    private final String id;
    private Boolean booked;
    private Vehicle parkVehicle;
    public Slot(String id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.booked = false;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public String getId() {
        return id;
    }

    public void setBooked(Boolean booked) {
        this.booked = booked;
    }
    public Boolean isBooked() {
        return this.booked;
    }

    public Vehicle getParkVehicle() {
        return parkVehicle;
    }

    public void setParkVehicle(Vehicle parkVehicle) {
        this.parkVehicle = parkVehicle;
    }

}
