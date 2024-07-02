package org.example.utms.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Vehicle {
    @Id
    @SequenceGenerator(name = "vehicle_sequence", sequenceName = "vehicle_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_sequence")
    private int id;
    private String name;
    private String type;
    private String brand;
    private String driveType;
    private int year;
    private String model;
    private int numOfRentals;
    private int status;

    @Column(name = "owner_id", nullable = false)
    private int ownerId;


    public Vehicle(int id, String name, String type, String brand, String model, String driveType, int year, int batteryLifeLevel, int batteryLevel, int numOfRentals, int status, int ownerId) {
        this.year = year;
        this.driveType = driveType;
        this.model = model;
        this.brand = brand;
        this.type = type;
        this.name = name;
        this.id = id;
        this.numOfRentals = numOfRentals;
        this.status = status;
        this.ownerId = ownerId;

    }

    public Vehicle() {

    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNumOfRentals() {
        return numOfRentals;
    }

    public void setNumOfRentals(int numOfRentals) {
        this.numOfRentals = numOfRentals;
    }
}
