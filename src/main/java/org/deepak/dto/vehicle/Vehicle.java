package org.deepak.dto.vehicle;

import org.deepak.dto.ParkingTicket;

public abstract class Vehicle {
    private final String licenseNo;
    private ParkingTicket parkingTicket;
    private final Class<?> parkingSpotClass;
    public abstract void assignTicket(ParkingTicket parkingTicket);

    public Vehicle(String licenseNo, Class<?> parkingSpotClass){
            this.licenseNo = licenseNo;
            this.parkingSpotClass = parkingSpotClass;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public Class<?> getParkingSpotClass() {
        return parkingSpotClass;
    }
}
