package org.deepak.dto.parkingSpot;

import org.deepak.dto.vehicle.Vehicle;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class ParkingSpot {
    private final int id;
    private boolean isFree;
    private Vehicle vehicle;
    protected int amount;
    private final int floor;
    private static final AtomicInteger counter = new AtomicInteger(0);

    public ParkingSpot(int amount, int floor) {
        this.isFree = true;
        this.amount = amount;
        this.vehicle = null;
        this.id = counter.incrementAndGet();
        this.floor= floor;
    }

    public boolean isFree(){
        return this.isFree;
    }
    
    public void assignVehicle(Vehicle vehicle){
        if (!this.isFree) {
            throw new IllegalStateException("Parking spot is already occupied");
        }
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        this.isFree = false;
        this.vehicle = vehicle;
    }
    public void removeVehicle(){
        this.isFree=true;
        this.vehicle = null;
    }

    public int getAmount() {
        return amount;
    }
}
