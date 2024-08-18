package ParkingLLD;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private static Building building =new Building();

    List<Floor> floors;

    private Building() {
       floors=new ArrayList<>();
    }

    public static Building getParkingBuilding(){
        return building;
    }

    public void addFloor(Floor floor){
        floors.add(floor);
    }

    public List<Floor> getAllFloors(){
        return floors;
    }

    public ParkingSlot getParkingSlot(Type type){
        StrategyAll strategyAll=StrategyAll.getSingletonObject();
        return strategyAll.findApporiateParking(type);
    }
}
