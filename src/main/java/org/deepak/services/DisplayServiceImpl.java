package org.deepak.services;

import org.deepak.dto.DisplayBoard;
import org.deepak.dto.ParkingLot;
import org.deepak.interfaces.DisplayService;

public class DisplayServiceImpl implements DisplayService {
    @Override
    public void update(Class<?> parkingSpotClass, int count) {
        DisplayBoard displayBoard = ParkingLot.getInstance().getDisplayBoard();
        Integer currentCount = displayBoard.getFreeParkingSpots().get(parkingSpotClass);
        if(currentCount == null) {
            currentCount = 0;
        }
        displayBoard.setFreeParkingSpots(parkingSpotClass, currentCount + count);
    }
}
