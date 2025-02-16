package CarRental;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class Car {

    private String carno;
    private double pricePerDay;
    private CarType carType;
    private List<Booking> bookings;


}
