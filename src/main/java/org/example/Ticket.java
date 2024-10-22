package org.example;

public class Ticket {
    private final String parkingLotId;
    private final String floorId;
    private final String slotId;

    public String getParkingLotId() {
        return parkingLotId;
    }

    public String getFloorId() {
        return floorId;
    }

    public String getSlotId() {
        return slotId;
    }

    public Ticket(String parkingLotId, String floorId, String slotId) {
        this.parkingLotId = parkingLotId;
        this.floorId = floorId;
        this.slotId = slotId;
    }

    public String toString(){
        return parkingLotId + "_" + floorId + "_" + slotId;
    }
    public static Ticket parseTicket(String ticket){
        String[] ids = ticket.split("_");
        return new Ticket(ids[0], ids[1], ids[2]);
    }
}
