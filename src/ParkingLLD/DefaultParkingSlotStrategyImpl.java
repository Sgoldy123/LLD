package ParkingLLD;

import java.util.List;

public class DefaultParkingSlotStrategyImpl implements ParkingSlotStrategy{

    public  ParkingSlot getParkingSlotStrategyAlgo(Type type){

        Building building = Building.getParkingBuilding();

        List<Floor> floors= building.getAllFloors();

        for(Floor floor:floors){
            for(ParkingSlot parkingSlot:floor.getList()){
                if(parkingSlot.getIsAvail() && type==parkingSlot.getParkingType()){
//                    System.out.println("Floor: "+ floor.getFloorID());
                    return parkingSlot;
                }
            }
        }

        return null;

    }
}
