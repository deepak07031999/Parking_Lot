package org.deepak;

import org.deepak.dto.DisplayBoard;
import org.deepak.dto.ParkingLot;
import org.deepak.dto.ParkingTicket;
import org.deepak.dto.parkingSpot.Compact;
import org.deepak.dto.parkingSpot.Electric;
import org.deepak.dto.parkingSpot.Large;
import org.deepak.dto.parkingSpot.ParkingSpot;
import org.deepak.dto.payment.CreditCard;
import org.deepak.dto.vehicle.Car;
import org.deepak.dto.vehicle.Vehicle;
import org.deepak.exceptions.InvalidTicketException;
import org.deepak.interfaces.ParkingSpotService;
import org.deepak.services.ParkingServiceImpl;
import org.deepak.services.ParkingSpotServiceImpl;

public class Main {
    public static void main(String[] args) throws InvalidTicketException, InterruptedException {

        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingSpotService parkingSpotService= new ParkingSpotServiceImpl();

        ParkingSpot a1 = parkingSpotService.createParkingSpot(Compact.class, 0);
        ParkingSpot a2 = parkingSpotService.createParkingSpot(Compact.class, 0);

        ParkingSpot b1 = parkingSpotService.createParkingSpot(Large.class, 0);
        ParkingSpot b2 = parkingSpotService.createParkingSpot(Large.class, 0);

        ParkingSpot c1 = parkingSpotService.createParkingSpot(Electric.class, 0);
        ParkingSpot c2 = parkingSpotService.createParkingSpot(Electric.class, 0);


        Vehicle v1 = new Car("HR26-01");
        Vehicle v2 = new Car("HR26-02");

        ParkingServiceImpl parkingLotService= new ParkingServiceImpl();
        System.out.println("count:" + parkingLot.getDisplayBoard().getFreeParkingSpots().get(v1.getParkingSpotClass()));
        ParkingTicket parkingTicket1 = parkingLotService.entry(v1);
        System.out.println("count:" + parkingLot.getDisplayBoard().getFreeParkingSpots().get(v1.getParkingSpotClass()));
        ParkingTicket parkingTicket2 = parkingLotService.entry(v2);
        System.out.println("count:" + parkingLot.getDisplayBoard().getFreeParkingSpots().get(v1.getParkingSpotClass()));
        Thread.sleep(1000);
        parkingTicket1.initiatePayment(new CreditCard("cardNo",22));
        parkingLotService.exit(parkingTicket1,v1);
        System.out.println("count:" + parkingLot.getDisplayBoard().getFreeParkingSpots().get(v1.getParkingSpotClass()));
    }
}