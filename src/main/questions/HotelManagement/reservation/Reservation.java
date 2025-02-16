package HotelManagement.reservation;

import HotelManagement.customer.Customer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Reservation {
    private Customer customer;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public Reservation(Customer customer, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.customer = customer;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}
