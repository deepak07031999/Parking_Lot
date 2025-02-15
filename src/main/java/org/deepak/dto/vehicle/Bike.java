package org.deepak.dto.vehicle;

import org.deepak.dto.ParkingTicket;
import org.deepak.dto.parkingSpot.MotorCycle;

public class Bike extends Vehicle{
    public Bike(String licenseNo) {
        super(licenseNo, MotorCycle.class);
    }

    @Override
    public void assignTicket(ParkingTicket parkingTicket) {
        this.setParkingTicket(parkingTicket);
    }
}
