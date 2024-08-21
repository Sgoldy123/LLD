package BookingMyShow;

public class Ticket {

    private int ticketId;
    private int userId;
    private int showId;
    private int seatNum;
    private int theaterId;
    private boolean isPaymentDone;

    public Ticket(int ticketId, int userId, int showId, int theaterId) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.showId = showId;
//        this.seatNum = seatNum;
        this.theaterId = theaterId;
        isPaymentDone=false;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public int getShowId() {
        return showId;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public boolean isPaymentDone() {
        return isPaymentDone;
    }

    public void setPaymentDone(boolean paymentDone) {
        isPaymentDone = paymentDone;
    }
    public void setSeatNum(int seatNum){
        this.seatNum=seatNum;
    }
}
