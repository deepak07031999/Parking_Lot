package org.deepak.dto;

import org.deepak.dto.parkingSpot.ParkingSpot;

import java.util.*;

import org.reflections.Reflections;

public class ParkingLot {
    private static volatile ParkingLot parkingLot;
    private final Map<Class<?>, List<ParkingSpot>> freeParkingSpots;
    private List<EntryPanel> entrances;
    private List<ExitPanel> exits;
    private final DisplayBoard displayBoard;
    private static final Map<Class<?>, List<ParkingSpot>> PARKING_SPOT_TYPES;
    
    static {
        Map<Class<?>, List<ParkingSpot>> types = new HashMap<>();
        Reflections reflections = new Reflections("org.deepak.dto.parkingSpot");
        Set<Class<? extends ParkingSpot>> subclasses = reflections.getSubTypesOf(ParkingSpot.class);
        for (Class<?> clazz : subclasses) {
            types.put(clazz, new ArrayList<>());
        }
        PARKING_SPOT_TYPES = Collections.unmodifiableMap(types);
    }

    private ParkingLot() {
        this.freeParkingSpots = new HashMap<>();
        for (Map.Entry<Class<?>, List<ParkingSpot>> entry : PARKING_SPOT_TYPES.entrySet()) {
            this.freeParkingSpots.put(entry.getKey(), new ArrayList<>());
        }
        this.displayBoard = new DisplayBoard();
        // Initialize display board with parking spot types
        for (Class<?> clazz : PARKING_SPOT_TYPES.keySet()) {
            this.displayBoard.setFreeParkingSpots(clazz, 0);
        }
    }

    public static ParkingLot getInstance() {
        if(parkingLot == null){
            synchronized(ParkingLot.class) {
                if(parkingLot == null) {
                    parkingLot = new ParkingLot();
                }
            }
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
}
