package com.gb.amazonlocker.model;

import com.gb.amazonlocker.utils.IdGenerator;

public class Locker {
    private String id;
    private LockerSize lockerSize;
    private String locationId;
    private LockerStatus lockerStatus;

    // Constructor
    public Locker(LockerSize lockerSize, String locationId) {
        this.id = IdGenerator.generateId(8);
        this.lockerSize = lockerSize;
        this.locationId = locationId;
        this.lockerStatus = LockerStatus.AVAILALBE;
    }

    // Getter for id
    public String getId() {
        return id;
    }

    // Setter for id
    public void setId(String id) {
        this.id = id;
    }

    // Getter for lockerSize
    public LockerSize getLockerSize() {
        return lockerSize;
    }

    // Setter for lockerSize
    public void setLockerSize(LockerSize lockerSize) {
        this.lockerSize = lockerSize;
    }

    // Getter for locationId
    public String getLocationId() {
        return locationId;
    }

    // Setter for locationId
    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    // Getter for lockerStatus
    public LockerStatus getLockerStatus() {
        return lockerStatus;
    }

    // Setter for lockerStatus
    public void setLockerStatus(LockerStatus lockerStatus) {
        this.lockerStatus = lockerStatus;
    }
}