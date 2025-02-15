package org.deepak.dto;

import org.deepak.dto.parkingSpot.ParkingSpot;
import org.deepak.dto.payment.Payment;
import org.deepak.dto.vehicle.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingTicket {
    private final Integer id;
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final LocalDateTime timestamp;
    private Integer amount;

    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        timestamp= LocalDateTime.now();
        id= counter.incrementAndGet();
    }

    public int getParkingHours(){
        Duration duration = Duration.between(this.timestamp, LocalDateTime.now());
        double hours = (double) duration.getSeconds()/ 3600.00;
        return (int) Math.ceil(hours);
    }
    public Integer getAmount() {
        this.amount = getParkingHours() * this.parkingSpot.getAmount();
        return this.amount;
    }
    public boolean initiatePayment(Payment payment){
        return payment.initiatePayment(getAmount());
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    public ParkingSpot getParkingSpot(){
        return parkingSpot;
    }
}
