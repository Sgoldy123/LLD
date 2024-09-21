package HotelManagement.staff;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;


@Getter
@Setter
public class Staff {
    private String staffid;
    private Role role;
    private LocalTime startShift;
    private LocalTime endShift;

    public Staff(String staffid, Role role, LocalTime startShift, LocalTime endShift) {
        this.staffid = staffid;
        this.role = role;
        this.startShift = startShift;
        this.endShift = endShift;
    }
}
