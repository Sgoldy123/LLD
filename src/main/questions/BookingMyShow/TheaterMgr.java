package BookingMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheaterMgr {

    private static TheaterMgr theaterMgr=new TheaterMgr();

    private Map<Location, List<Theater>> theaterList;

    private TheaterMgr(){
        theaterList=new HashMap<>();
    }
    public static TheaterMgr getInstance(){
        return theaterMgr;
    }
    public void addTheater(Location location,Theater theater){
        if(!theaterList.containsKey(location)){
            theaterList.put(location,new ArrayList<>());
        }
        theaterList.get(location).add(theater);
    }

    public  List<Theater> getAllTheaterWithLocation(Location location){
       return theaterList.get(location);
    }

    public Theater getTheater(int id,Location location){
        List<Theater> theaterList1=theaterList.get(location);
        for(Theater theater:theaterList1){
            if(theater.getTheaterId()==id){
                return theater;
            }
        }
        return null;
    }
}
