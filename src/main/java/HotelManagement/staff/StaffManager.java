package HotelManagement.staff;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StaffManager {
    private List<Staff> staffList;
    public StaffManager(){
        staffList=new ArrayList<>();
    }
}
