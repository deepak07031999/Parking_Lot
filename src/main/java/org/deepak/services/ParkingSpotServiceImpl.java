package org.deepak.services;

import org.deepak.dto.ParkingLot;
import org.deepak.dto.parkingSpot.ParkingSpot;
import org.deepak.interfaces.DisplayService;
import org.deepak.interfaces.ParkingSpotService;

public class ParkingSpotServiceImpl  implements ParkingSpotService {
    DisplayService displayService= new DisplayServiceImpl();
    @Override
    public ParkingSpot createParkingSpot(Class<?> parkingSpotClass, Integer floor) {
        try{
            ParkingSpot parkingSpot = (ParkingSpot) parkingSpotClass.getDeclaredConstructor(Integer.class).newInstance(floor);
            ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpotClass).add(parkingSpot);
            displayService.update(parkingSpotClass,1);
            return parkingSpot;
        }
        catch (Exception e){
            throw new RuntimeException("Error creating parking spot of type " + parkingSpotClass.getName(), e);
        }
    }
}
