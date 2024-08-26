package ParkingLLD;

public class Entry {

    private  static Entry entry=new Entry();
    private Entry(){

    }
    public Ticket createTicket(Vehicle vehicle){
        Building building=Building.getParkingBuilding();
        ParkingSlot parkingSlot=building.getParkingSlot(Type.CAR);  //find available parking slot;
        if(parkingSlot==null){
            System.out.println("NO parking slot is available!! "+vehicle.getNumber()+" "+vehicle.getVechileType());
            return null;
        }


        //entry time
        Ticket ticket=new Ticket(1,parkingSlot,vehicle);
        parkingSlot.setAvail(false);
        parkingSlot.setVehicle(vehicle);

        System.out.println("Parking Slot alloted Vehicle no."+ ticket.getVehicle().getNumber()+" floor no:"+parkingSlot.getFloorId()+" parking slot:"+parkingSlot.getParkingid()+" type "+vehicle.getVechileType());
        return ticket;

    }

    public static Entry getEntryInstance(){
        return entry;
    }

}
