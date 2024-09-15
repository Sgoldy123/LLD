package CarRental;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Booking {
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;

    public Booking(Customer customer,LocalDate startDate,LocalDate endDate){
        this.customer=customer;
        this.startDate=startDate;
        this.endDate=endDate;
    }
}
