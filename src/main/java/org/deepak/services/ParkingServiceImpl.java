package org.deepak.services;

import org.deepak.dto.ParkingLot;
import org.deepak.dto.ParkingTicket;
import org.deepak.dto.parkingSpot.ParkingSpot;
import org.deepak.dto.vehicle.Vehicle;
import org.deepak.exceptions.InvalidTicketException;
import org.deepak.interfaces.DisplayService;
import org.deepak.interfaces.ParkingService;

import java.util.List;
import java.util.logging.Logger;

public class ParkingServiceImpl implements ParkingService {
    private static final Logger logger = Logger.getLogger(ParkingServiceImpl.class.getName());
    private final DisplayService displayService;
    private final ParkingLot parkingLot;

    public ParkingServiceImpl() {
        this.displayService = new DisplayServiceImpl();
        this.parkingLot = ParkingLot.getInstance();
    }

    @Override
    public ParkingTicket entry(Vehicle vehicle) {
        if (vehicle == null || vehicle.getLicenseNo() == null) {
            throw new IllegalArgumentException("Vehicle and license number cannot be null");
        }
        
        logger.info("Vehicle entry: " + vehicle.getClass().getSimpleName() + ", License: " + sanitizeInput(vehicle.getLicenseNo()));
        
        List<ParkingSpot> freeParkingSpots = parkingLot.getFreeParkingSpots().get(vehicle.getParkingSpotClass());
        if (freeParkingSpots == null || freeParkingSpots.isEmpty()) {
            throw new RuntimeException("No parking spots available for vehicle type: " + vehicle.getClass().getSimpleName());
        }
        
        ParkingSpot parkingSpot = freeParkingSpots.getFirst();
        if(parkingSpot.isFree()){
            synchronized (parkingSpot){
                if(parkingSpot.isFree()){
                    parkingSpot.assignVehicle(vehicle);
                    freeParkingSpots.remove(parkingSpot);
                    displayService.update(vehicle.getParkingSpotClass(),-1);
                    return new ParkingTicket(vehicle, parkingSpot);
                }
            }
        }
        throw new RuntimeException("Unable to assign parking spot");
    }

    @Override
    public int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException {
        if (parkingTicket == null || vehicle == null) {
            throw new IllegalArgumentException("Parking ticket and vehicle cannot be null");
        }
        
        if(parkingTicket.getVehicle().equals(vehicle)){
            ParkingSpot parkingSpot = parkingTicket.getParkingSpot();
            parkingSpot.removeVehicle();
            parkingLot.getFreeParkingSpots().get(vehicle.getParkingSpotClass()).add(parkingSpot);
            displayService.update(vehicle.getParkingSpotClass(),1);
            return (int) parkingTicket.getAmount();
        } else{
            throw new InvalidTicketException("This is an invalid ticket");
        }
    }
    
    private String sanitizeInput(String input) {
        return input.replaceAll("[\r\n]", "_");
    }
}
