package ParkingLLD;

public class StrategyAll {

    static private  StrategyAll strategyAll=new StrategyAll();

    private StrategyAll(){

    }

    public static StrategyAll getSingletonObject(){
        return strategyAll;
    }

    public ParkingSlot findApporiateParking(Type type){
        ParkingSlotStrategy parkingSlotStrategy=new DefaultParkingSlotStrategyImpl();
        return parkingSlotStrategy.getParkingSlotStrategyAlgo(type);
    }
}
