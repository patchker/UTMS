package org.example.utms.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


public class Scooter extends Vehicle{
    private int batteryLevel;
    private int batteryLifeLevel;
    private int numOfRentals;


    public Scooter(int id, String name, String type, String brand, String model, String driveType, int year, int numOfRentals, int batteryLifeLevel, int batteryLevel) {
        super(id,name,type,brand,model,driveType,year);
        this.numOfRentals = numOfRentals;
        this.batteryLifeLevel = batteryLifeLevel;
        this.batteryLevel = batteryLevel;
    }

    public Scooter() {

    }

    public int getNumOfRentals() {
        return numOfRentals;
    }

    public void setNumOfRentals(int numOfRentals) {
        this.numOfRentals = numOfRentals;
    }

    public int getBatteryLifeLevel() {
        return batteryLifeLevel;
    }

    public void setBatteryLifeLevel(int batteryLifeLevel) {
        this.batteryLifeLevel = batteryLifeLevel;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

}
