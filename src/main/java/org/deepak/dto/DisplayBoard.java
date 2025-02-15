package org.deepak.dto;

import org.deepak.dto.parkingSpot.ParkingSpot;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DisplayBoard {
    private static DisplayBoard displayBoard= null;
    private final Map<Class<?>, Integer> freeParkingSpots;

    private DisplayBoard() {
        this.freeParkingSpots = new HashMap<>();
        Reflections reflections = new Reflections("org.deepak.dto.parkingSpot");
        Set<Class<? extends ParkingSpot>> subclasses = reflections.getSubTypesOf(ParkingSpot.class);
        for (Class<?> clazz : subclasses) {
            this.freeParkingSpots.put(clazz, 0);
        }
    }

    public static DisplayBoard getInstance(){
        if(displayBoard== null){
            displayBoard= new DisplayBoard();
        }
        return displayBoard;
    }

    public Map<Class<?>, Integer> getFreeParkingSpots() {
        return freeParkingSpots;
    }
}
