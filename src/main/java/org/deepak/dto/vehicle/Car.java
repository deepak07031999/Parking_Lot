package org.deepak.dto.vehicle;

import org.deepak.dto.ParkingTicket;
import org.deepak.dto.parkingSpot.Compact;

public class Car extends Vehicle{
    public Car(String licenseNo) {
        super(licenseNo, Compact.class);
    }

    @Override
    public void assignTicket(ParkingTicket parkingTicket) {
        this.setParkingTicket(parkingTicket);
    }
}
