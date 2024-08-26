package ParkingLLD;

import java.util.ArrayList;
import java.util.List;

public class Orchestrator {

   public static void main(String []args){
       int totFloor=3,totParkingSlot=10;

       Building building=Building.getParkingBuilding();

       for(int i=0;i<totFloor;i++){
           Floor floor=new Floor(i);
           for(int j=0;j<totParkingSlot;j++){
               ParkingSlot parkingSlot;
                 if(j==0){
                     parkingSlot=new ParkingSlot(j,true,Type.TRUCK,i);
                 }
                 else if(j<=2){
                     parkingSlot=new ParkingSlot(j,true,Type.BIKE,i);
                 }
                 else{
                     parkingSlot=new ParkingSlot(j,true,Type.CAR,i);
                 }
                 floor.addParkingSlot(parkingSlot);
           }
           building.addFloor(floor);
       }




       Entry entry=Entry.getEntryInstance();
       Exit exit=Exit.getParkingInstance();
       List<Ticket> ticketList=new ArrayList<>();

       // Vehicle are entering
       for(int i=0;i<30;i++){
           Vehicle vehicle;
           if(i%3==0){
                vehicle=new Vehicle(""+i,Type.BIKE);
           }
           else if(i%5==0){
               vehicle=new Vehicle(""+i,Type.TRUCK);
           }
           else{
               vehicle=new Vehicle(""+i,Type.CAR);
           }


           try {
               Ticket ticket=entry.createTicket(vehicle);
               ticketList.add(ticket);
               Thread.sleep(2000);
           }
           catch (Exception e){

           }

       }


       // vechicle are exiting
//       for(Ticket ticket:ticketList){
//           double price= exit.calPrice(ticket);
//           Payment payment=exit.doPayment(price,ticket);
//           if(payment.isPaymentStatus()){
//               exit.updateParkingSlot(ticket.getParkingSlot());
//           }
//       }





   }
}
