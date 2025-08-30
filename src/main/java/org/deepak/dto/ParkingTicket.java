package org.deepak.dto;

import org.deepak.dto.parkingSpot.ParkingSpot;
import org.deepak.dto.payment.Payment;
import org.deepak.dto.vehicle.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingTicket {
    private final int id;
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final LocalDateTime timestamp;
    private Integer cachedAmount;
    private LocalDateTime lastCalculationTime;

    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;

    public ParkingTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        if (vehicle == null || parkingSpot == null) {
            throw new IllegalArgumentException("Vehicle and parking spot cannot be null");
        }
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.timestamp = LocalDateTime.now();
        this.id = counter.incrementAndGet();
    }

    public int getParkingHours(LocalDateTime currentTime){
        Duration duration = Duration.between(this.timestamp, currentTime);
        double hours = (double) duration.getSeconds() / 3600.0;
        return Math.max(1, (int) Math.ceil(hours));
    }
    
    public int getAmount() {
        LocalDateTime now = LocalDateTime.now();
        if (cachedAmount == null || !now.equals(lastCalculationTime)) {
            this.cachedAmount = getParkingHours(now) * this.parkingSpot.getAmount();
            this.lastCalculationTime = now;
        }
        return this.cachedAmount;
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
