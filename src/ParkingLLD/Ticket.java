package ParkingLLD;

import java.util.Date;

public class Ticket {
    private Date time;
    private int ticketId;
    private ParkingSlot parkingSlot;
    private Vehicle vehicle;
    private double price;
    public Ticket(int ticketId, ParkingSlot parkingSlot, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.parkingSlot = parkingSlot;
        this.vehicle = vehicle;
        this.time=new Date();
    }

    public int getTicketId() {
        return ticketId;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public double getPrice() {
        return price;
    }

    public Date getTime(){
        return time;
    }
}
