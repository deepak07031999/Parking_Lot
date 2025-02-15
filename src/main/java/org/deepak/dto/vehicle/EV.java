package org.deepak.dto.vehicle;

import org.deepak.dto.ParkingTicket;
import org.deepak.dto.parkingSpot.Electric;

public class EV extends Vehicle{
    public EV(String licenseNo) {
        super(licenseNo, Electric.class);
    }

    @Override
    public void assignTicket(ParkingTicket parkingTicket) {
        this.setParkingTicket(parkingTicket);
    }
}
