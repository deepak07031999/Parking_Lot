package org.deepak.dto;

import org.deepak.dto.parkingSpot.ParkingSpot;

import java.util.*;

import org.reflections.Reflections;

public class ParkingLot {
    private static ParkingLot parkingLot;
    private final Map<Class<?>, List<ParkingSpot>> freeParkingSpots;
    private List<EntryPanel> entrances;
    private List<ExitPanel> exits;
    private DisplayBoard displayBoard;

    public ParkingLot() {
        this.freeParkingSpots = new HashMap<>();
        Reflections reflections = new Reflections("org.deepak.dto.parkingSpot");
        Set<Class<? extends ParkingSpot>> subclasses = reflections.getSubTypesOf(ParkingSpot.class);
        for (Class<?> clazz : subclasses) {
            this.freeParkingSpots.put(clazz, new ArrayList<>());
        }
        displayBoard= DisplayBoard.getInstance();
    }

    public static ParkingLot getInstance() {
        if(parkingLot == null){
           parkingLot = new ParkingLot();
        }
        return parkingLot;
    }
    public Map<Class<?>, List<ParkingSpot>> getFreeParkingSpots() {
        return freeParkingSpots;
    }
    public List<EntryPanel> getEntrances() {
        return entrances;
    }

    public void setEntrances(List<EntryPanel> entrances) {
        this.entrances = entrances;
    }

    public List<ExitPanel> getExits() {
        return exits;
    }

    public void setExits(List<ExitPanel> exits) {
        this.exits = exits;
    }
    public DisplayBoard getDisplayBoard() {
        return displayBoard;
    }

    public void setDisplayBoard(DisplayBoard displayBoard) {
        this.displayBoard = displayBoard;
    }
}
