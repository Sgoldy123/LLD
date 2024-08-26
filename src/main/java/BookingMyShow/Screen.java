package BookingMyShow;

public class Screen {

    private int screenId;
   private Movie movie;
   private  Seats seat;
   private int startTime;
   private int endTime;
   private int price;


    public Screen(int screenId, Movie movie, Seats seat, int startTime, int price) {
        this.screenId = screenId;
        this.movie = movie;
        this.seat = seat;
        this.startTime = startTime;
        this.price = price;
    }

    public int getScreenId() {
        return screenId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Seats getSeat() {
        return seat;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getPrice() {
        return price;
    }

    public void bookSeat(int seatNum){
        seat.getSeatList().set(seatNum,false);
    }
}
