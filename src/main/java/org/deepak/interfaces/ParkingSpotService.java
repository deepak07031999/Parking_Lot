package org.deepak.interfaces;

import org.deepak.dto.ParkingLot;
import org.deepak.dto.parkingSpot.ParkingSpot;

public interface ParkingSpotService {
    public ParkingSpot createParkingSpot(Class<?> parkingSpotClass, Integer floor);
}
