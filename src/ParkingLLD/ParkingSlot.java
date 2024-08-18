package ParkingLLD;

public class ParkingSlot {

    int floorId;
    int parkingid;
    Vehicle vehicle;
    boolean isAvail;
    Type parkingType;


    public ParkingSlot(int parkingid, boolean isAvail, Type parkingType,int floorId) {
        this.parkingid = parkingid;
        this.isAvail = isAvail;
        this.parkingType = parkingType;
        this.floorId=floorId;
    }

    public int getParkingid() {
        return parkingid;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean getIsAvail() {
        return isAvail;
    }

    public Type getParkingType() {
        return parkingType;
    }
    public void setAvail(boolean isAvail){
        this.isAvail=isAvail;
    }
    public void setVehicle(Vehicle vehicle){
        this.vehicle=vehicle;
    }

    public int getFloorId() {
        return floorId;
    }
}
