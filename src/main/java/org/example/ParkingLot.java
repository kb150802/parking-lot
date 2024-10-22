package org.example;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final String id;
    private final List<Floor> floors;
    public ParkingLot(String id, int noOfFloors,int slotsOnEachFloor){
        this.id = id;
        floors = new ArrayList<>();
        for(int i = 1; i<= noOfFloors; ++i) {
            floors.add(new Floor(Integer.toString(i), slotsOnEachFloor));
        }
    }
    public String getId(){
        return this.id;
    }
    public List<List<String>> getFreeSlots(VehicleType vehicleType){
        List<List<String>> freeSlots = new ArrayList<>();
        for(Floor floor: floors) {
            List<String> freeSlotsOnThisFloor = floor.getFreeSlots(vehicleType);
            freeSlots.add(freeSlotsOnThisFloor);
        }
        return freeSlots;
    }
    public List<List<String>> getOccupiedSlots(VehicleType vehicleType) {
        List<List<String>> occupiedSlots = new ArrayList<>();
        for(Floor floor: floors) {
            List<String> freeSlotsOnThisFloor = floor.getOccupiedSlots(vehicleType);
            occupiedSlots.add(freeSlotsOnThisFloor);
        }
        return occupiedSlots;
    }
    public List<Integer> getFreeSlotsCount(VehicleType vehicleType) {
        List<List<String>> freeSlots = getFreeSlots(vehicleType);
        List<Integer> freeSlotsCount = new ArrayList<>();
        for(List<String> freeSlotsOnEachFloor: freeSlots ){
            freeSlotsCount.add(freeSlotsOnEachFloor.size());
        }
        return freeSlotsCount;
    }
    public List<Integer> getOccupiedSlotsCount(VehicleType vehicleType) {
        List<List<String>> occupiedSlots = getOccupiedSlots(vehicleType);
        List<Integer> occupiedSlotsCount = new ArrayList<>();
        for(List<String> freeSlotsOnEachFloor: occupiedSlots){
            occupiedSlotsCount.add(freeSlotsOnEachFloor.size());
        }
        return occupiedSlotsCount;
    }
    public Ticket parkVehicle(Vehicle vehicle){
        for(Floor floor : floors) {
            for(Slot slot : floor.getSlots()) {
                if(!slot.isBooked() && slot.getVehicleType() == vehicle.getVehicleType()){
                    slot.setParkVehicle(vehicle);
                    slot.setBooked(true);
                    return new Ticket(this.id, floor.getId(),slot.getId());
                }
            }
        }
        return null;
    }
    public Vehicle unparkVehicle(String ticketString) {
        try{
            Ticket ticket = Ticket.parseTicket(ticketString);
            Floor floor = floors.get(Integer.parseInt(ticket.getFloorId()) - 1);
            Slot slot = floor.getSlots().get(Integer.parseInt(ticket.getSlotId()) - 1);
            Vehicle parkedVehicle = slot.getParkVehicle();
            if(parkedVehicle == null){
                throw new Exception();
            }
            slot.setParkVehicle(null);
            slot.setBooked(false);
            return parkedVehicle;
        }catch (Exception exception){
            System.out.println("INVALID TICKET " + ticketString);
        }
        return null;
    }
}
