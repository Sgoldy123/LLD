package HotelManagement.customer;

import HotelManagement.Hotel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Customer {
    private String customerId;
    private Order order;

    public Customer(String customerId, Hotel hotel) {
        this.customerId = customerId;
        this.order=new Order(hotel);
    }
}
