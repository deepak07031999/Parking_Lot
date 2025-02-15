package org.deepak.interfaces;

import org.deepak.dto.ParkingTicket;
import org.deepak.dto.vehicle.Vehicle;
import org.deepak.exceptions.InvalidTicketException;

public interface ParkingService {
    public ParkingTicket entry(Vehicle vehicle);
    public int exit(ParkingTicket parkingTicket, Vehicle vehicle) throws InvalidTicketException;
}
