package ParkingLLD;

public class Payment {
    int paymentId;
    Ticket ticket;
    double price;
    boolean paymentStatus;

    public Payment(int paymentId, Ticket ticket, double price) {
        this.paymentId = paymentId;
        this.ticket = ticket;
        this.price = price;
        this.paymentStatus = false;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
