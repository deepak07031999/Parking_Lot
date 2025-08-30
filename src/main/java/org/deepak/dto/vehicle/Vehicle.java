package org.deepak.dto.vehicle;

import org.deepak.dto.ParkingTicket;

public abstract class Vehicle {
    private final String licenseNo;
    private ParkingTicket parkingTicket;
    private final Class<?> parkingSpotClass;
    public abstract void assignTicket(ParkingTicket parkingTicket);

    public Vehicle(String licenseNo, Class<?> parkingSpotClass){
        if (licenseNo == null || licenseNo.trim().isEmpty()) {
            throw new IllegalArgumentException("License number cannot be null or empty");
        }
        if (parkingSpotClass == null) {
            throw new IllegalArgumentException("Parking spot class cannot be null");
        }
        this.licenseNo = licenseNo;
        this.parkingSpotClass = parkingSpotClass;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }
    
    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public Class<?> getParkingSpotClass() {
        return parkingSpotClass;
    }
}
