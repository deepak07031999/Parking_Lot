package org.deepak.services;

import org.deepak.dto.DisplayBoard;
import org.deepak.interfaces.DisplayService;

public class DisplayServiceImpl implements DisplayService {
    @Override
    public void update(Class<?> ParkingSpotClass, int count) {
        Integer currentCount = DisplayBoard.getInstance().getFreeParkingSpots().get(ParkingSpotClass);
        if(currentCount == null)
        {
            currentCount=0;
        }
        int newCount= currentCount+ count;
        DisplayBoard.getInstance().getFreeParkingSpots().replace(ParkingSpotClass, newCount);

    }
}
