package org.deepak.dto.parkingSpot;

public class Electric extends ParkingSpot{
    private static final int ELECTRIC_SPOT_RATE = 30;
    
    public Electric(int floor) {
        super(ELECTRIC_SPOT_RATE, floor);
    }
}
