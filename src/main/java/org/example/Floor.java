package org.example;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private final List<Slot> slots;
    private final String id;
    public Floor(String id , int numberOfSlots) {
        this.slots = new ArrayList<>();
        slots.add(new Slot("1", VehicleType.Truck));
        slots.add(new Slot("2", VehicleType.Bike));
        slots.add(new Slot("3", VehicleType.Bike));
        for(int i = 4; i <= numberOfSlots; ++i) {
            slots.add(new Slot(Integer.toString(i), VehicleType.Car));
        }
        this.id = id;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public String getId() {
        return id;
    }

    public List<String> getFreeSlots(VehicleType vehicleType) {
        List<String> freeSlots = new ArrayList<>();
        for(Slot slot : slots) {
            if(!slot.isBooked() && slot.getVehicleType() == vehicleType) {
                freeSlots.add(slot.getId());
            }
        }
        return freeSlots;
    }
    public List<String> getOccupiedSlots(VehicleType vehicleType) {
        List<String> occupiedSlots = new ArrayList<>();
        for(Slot slot: slots) {
            if(slot.isBooked() && slot.getVehicleType() == vehicleType){
                occupiedSlots.add(slot.getId());
            }
        }
        return occupiedSlots;
    }
}
