package ParkingLLD;

import java.util.Date;

public class Exit {

    private static Exit exit=new Exit();
    private Exit(){

    }

    public  static Exit getParkingInstance(){
        return exit;
    }

    public  double calPrice(Ticket ticket){

        Date currTime=new Date();
        Date entryTime=ticket.getTime();


        long totTime=(currTime.getTime()-entryTime.getTime());
        totTime=totTime/(1000);
        double price=0;
        if(ticket.getVehicle().getVechileType()==Type.BIKE){
            price=totTime*50;
        }
        else if(ticket.getVehicle().getVechileType()==Type.CAR){
            price=totTime*100;
        }
        else{
            price=totTime*150;
        }

        System.out.println("Parking Price "+ ticket.getVehicle().getNumber()+" "+price);
        return price;

    }
    public  Payment doPayment(double price, Ticket ticket){
        Payment payment=new Payment(1,ticket,price);
        payment.setPaymentStatus(true);
        System.out.println("Payment Done "+ ticket.getVehicle().getNumber());
        return payment;
    }

    public  void updateParkingSlot(ParkingSlot parkingSlot){

        System.out.println("floor: "+parkingSlot.getFloorId()+ " Parking Slot Update "+ parkingSlot.getParkingid()+" is Available Now");
       parkingSlot.setAvail(true);
    }
}
