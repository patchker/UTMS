package org.example.utms.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@DiscriminatorValue("SCOOTER")
public class Scooter extends Vehicle{
    private int batteryLevel;
    private int batteryLifeLevel;

    public Scooter(int id, String name, String type, String brand, String model, String driveType, int year, int batteryLifeLevel, int batteryLevel, int numOfRentals, int status, int ownerId) {
        super(id, name, type, brand, model, driveType, year,batteryLifeLevel,batteryLevel, numOfRentals, status, ownerId);
        this.batteryLifeLevel = batteryLifeLevel;
        this.batteryLevel = batteryLevel;
    }

    public Scooter() {

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
