package BookingMyShow;

import java.util.ArrayList;
import java.util.List;

public class Seats {

    private List<Boolean> seatList;

    public Seats(){
        seatList=new ArrayList<>();
        for(int i=0;i<10;i++){
            seatList.add(true);
        }
    }

    public List<Boolean> getSeatList() {
        return seatList;
    }
}
