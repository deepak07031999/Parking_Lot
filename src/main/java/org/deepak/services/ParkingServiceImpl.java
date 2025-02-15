package org.deepak.services;

import org.deepak.dto.ParkingLot;
import org.deepak.dto.ParkingTicket;
import org.deepak.dto.parkingSpot.ParkingSpot;
import org.deepak.dto.vehicle.Vehicle;
import org.deepak.exceptions.InvalidTicketException;
import org.deepak.interfaces.DisplayService;
import org.deepak.interfaces.ParkingService;

import java.util.List;

public class ParkingServiceImpl implements ParkingService {
    DisplayService displayService= new DisplayServiceImpl();

    public ParkingServiceImpl() {
    }

    @Override
    public ParkingTicket entry(Vehicle vehicle) {
        System.out.println(vehicle.getClass());
        System.out.println(vehicle.getLicenseNo());
        List<ParkingSpot> freeParkingSpots = ParkingLot.getInstance().getFreeParkingSpots().get(vehicle.getParkingSpotClass());
        ParkingSpot parkingSpot = freeParkingSpots.getFirst();
        if(parkingSpot.getIsFree()){
            synchronized (parkingSpot){
                if(parkingSpot.getIsFree()){
                    parkingSpot.assignVehicle(vehicle);
                    freeParkingSpots.remove(parkingSpot);
                    displayService.update(vehicle.getParkingSpotClass(),-1);
                    return new ParkingTicket(vehicle, parkingSpot);
                }
                entry(vehicle);
            }
        }
        return null;
    }

    @Override
    public int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException {
        if(parkingTicket.getVehicle().equals(vehicle)){
            ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
            parkingSpot.removeVehicle();
            ParkingLot.getInstance().getFreeParkingSpots().get(vehicle.getParkingSpotClass()).add(parkingSpot);
            displayService.update(vehicle.getParkingSpotClass(),1);

        } else{
            throw new InvalidTicketException("This is an invalid ticket");
        }
        return 0;
    }
}
