package BookingMyShow;

import java.util.ArrayList;
import java.util.List;

public class Theater {

    private int theaterId;
    private List<Show> shows;


    public Theater(int theaterId) {
        this.theaterId = theaterId;
        this.shows = new ArrayList<>();
    }

    public int getTheaterId() {
        return theaterId;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(Show show) {
        this.shows.add(show);
    }

    public Show getShow(int id){
        for(Show show:shows){
            if(show.getScreen().getScreenId()==id){
                return show;
            }
        }
        return null;
    }
}
