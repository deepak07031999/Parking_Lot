package org.deepak.dto.parkingSpot;

public class Large extends ParkingSpot{
    private static final int LARGE_SPOT_RATE = 40;
    
    public Large(int floor) {
        super(LARGE_SPOT_RATE, floor);
    }
}
