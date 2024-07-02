package org.example.utms.model;

public class Car extends Vehicle{
    private int fuel;

    private int maxFuel;

    public Car(int fuel, int maxFuel) {
        this.fuel = fuel;
        this.maxFuel = maxFuel;
    }

    public Car(int id, String name, String type, String brand, String model, String driveType, int year, int batteryLifeLevel, int batteryLevel, int numOfRentals, int status, int ownerId) {
        super(id, name, type, brand, model, driveType, year,batteryLifeLevel,batteryLevel, numOfRentals, status, ownerId);
        this.fuel = fuel;
        this.maxFuel = maxFuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    public void setMaxFuel(int maxFuel) {
        this.maxFuel = maxFuel;
    }
}

