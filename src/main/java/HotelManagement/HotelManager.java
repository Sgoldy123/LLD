package HotelManagement;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class HotelManager {
    private static HotelManager hotelManager=new HotelManager();
    private List<Hotel> hotelList;
    private HotelManager(){
        hotelList=new ArrayList<>();
    }

    public static HotelManager getInstance(){
        return hotelManager;
    }

}
