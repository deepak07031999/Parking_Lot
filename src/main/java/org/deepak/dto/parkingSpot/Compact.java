package org.deepak.dto.parkingSpot;

public class Compact extends ParkingSpot{
    private static final int COMPACT_SPOT_RATE = 20;

    public Compact(int floor) {
        super(COMPACT_SPOT_RATE, floor);
    }
}
