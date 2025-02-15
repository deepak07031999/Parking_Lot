package org.deepak.dto.account;

import org.deepak.dto.DisplayBoard;
import org.deepak.dto.EntryPanel;
import org.deepak.dto.ExitPanel;
import org.deepak.dto.ParkingLot;
import org.deepak.dto.parkingSpot.ParkingSpot;
import org.deepak.interfaces.DisplayService;
import org.deepak.services.DisplayServiceImpl;

public class Admin extends Account {
    DisplayService displayService = new DisplayServiceImpl();
    public boolean addParkingSpot(ParkingSpot parkingSpot){
        ParkingLot.getInstance().getFreeParkingSpots().get(parkingSpot.getClass()).add(parkingSpot);
        displayService.update(parkingSpot.getClass(),1);
        return true;
    }
    public boolean addDisplayBoard(DisplayBoard displayBoard){
        return true;
    }
    public boolean addEntrance(EntryPanel entryPanel){
        ParkingLot.getInstance().getEntrances().add(entryPanel);
        return true;
    }
    public boolean addExit(ExitPanel exitPanel){
        ParkingLot.getInstance().getExits().add(exitPanel);
        return true;
    }

    public boolean resetPassword(String username) {
        return true;
        // definition
    }
}
