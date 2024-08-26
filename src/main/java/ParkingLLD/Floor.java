package ParkingLLD;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    int floorID;
    List<ParkingSlot> parkingSlots;

    public Floor(int floorID) {
        this.floorID = floorID;
        parkingSlots=new ArrayList<>();
    }

    public int getFloorID() {
        return floorID;
    }

    public List<ParkingSlot> getList() {
        return parkingSlots;
    }

    public void addParkingSlot(ParkingSlot parkingSlot){
        parkingSlots.add(parkingSlot);
    }
}
