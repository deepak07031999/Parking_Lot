package org.deepak.dto.vehicle;

import org.deepak.dto.ParkingTicket;
import org.deepak.dto.parkingSpot.Large;

public class Truck extends Vehicle{
    public Truck(String licenseNo) {
        super(licenseNo, Large.class);
    }

    @Override
    public void assignTicket(ParkingTicket parkingTicket) {
        this.setParkingTicket(parkingTicket);
    }
}
