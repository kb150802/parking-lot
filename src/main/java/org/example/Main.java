package org.example;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("PR1234", 2, 6);
        System.out.println(parkingLot.parkVehicle(new Vehicle(VehicleType.Car, "KA-01-DB-1234", "black")));
        System.out.println(parkingLot.parkVehicle(new Vehicle(VehicleType.Car, "KA-02-DB-1334", "red")));
        System.out.println(parkingLot.parkVehicle(new Vehicle(VehicleType.Car, "KA-01-DB-1133", "black")));
        System.out.println(parkingLot.parkVehicle(new Vehicle(VehicleType.Car, "KA-05-DB-8432", "white")));
        System.out.println(parkingLot.parkVehicle(new Vehicle(VehicleType.Car, "WB-45-HO-9032", "white")));
        System.out.println(parkingLot.parkVehicle(new Vehicle(VehicleType.Car, "KA-01-DF-8230", "black")));
        System.out.println(parkingLot.parkVehicle(new Vehicle(VehicleType.Car, "KA-21-HS-2347", "red")));
        System.out.println(parkingLot.unparkVehicle("PR1234_2_5"));
        System.out.println(parkingLot.unparkVehicle("PR1234_2_5"));
        System.out.println(parkingLot.unparkVehicle("PR1234_2_7"));
        System.out.println(parkingLot.getOccupiedSlots(VehicleType.Car));
        System.out.println(parkingLot.parkVehicle(new Vehicle(VehicleType.Truck, "abcd", "red")));
        System.out.println(parkingLot.parkVehicle(new Vehicle(VehicleType.Truck, "abcd", "red")));
        System.out.println(parkingLot.unparkVehicle("PR1234_1_1"));
        System.out.println(parkingLot.parkVehicle(new Vehicle(VehicleType.Truck, "abcd", "red")));
    }
}