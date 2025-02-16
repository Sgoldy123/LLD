package HotelManagement.reservation;

import HotelManagement.customer.Customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationManager {

    private int totTables;
    private Map<Integer, List<Reservation>> tableVsReservation;

    public  ReservationManager(int totTables){
        tableVsReservation=new HashMap<>();
        this.totTables=totTables;
    }

    public void bookReservation(Customer customer, LocalDateTime startDateTime,LocalDateTime endDateTime){
        for(int i=0;i<totTables;i++){
            if(tableVsReservation.containsKey(i)){
                List<Reservation> reservations=tableVsReservation.get(i);
                boolean flag=true;
                for(Reservation reservation:reservations){
                    if(endDateTime.isBefore(reservation.getStartDateTime()) || startDateTime.isAfter(reservation.getEndDateTime())){

                    }
                    else{
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    Reservation reservation=new Reservation(customer,startDateTime,endDateTime);
                    tableVsReservation.get(i).add(reservation);
                    System.out.println("Table no. "+ i +" is booked");
                    return;
                }
            }
            else{
                tableVsReservation.put(i,new ArrayList<>());
                Reservation reservation=new Reservation(customer,startDateTime,endDateTime);
                tableVsReservation.get(i).add(reservation);
                System.out.println("Table no. "+ i +" is booked");
                return;
            }
        }

    }

}
