package org.deepak.dto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DisplayBoard {
    private final Map<Class<?>, Integer> freeParkingSpots;

    public DisplayBoard() {
        this.freeParkingSpots = new HashMap<>();
    }

    public Map<Class<?>, Integer> getFreeParkingSpots() {
        return Collections.unmodifiableMap(freeParkingSpots);
    }
    
    public void setFreeParkingSpots(Class<?> parkingSpotClass, int count) {
        freeParkingSpots.put(parkingSpotClass, count);
    }
}
