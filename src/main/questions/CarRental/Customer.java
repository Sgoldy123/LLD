package CarRental;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public class Customer {
    private String customerId;
    private List<String> customerCarList;

    public Customer(String customerId){
        this.customerId=customerId;
        customerCarList=new ArrayList<>();
    }

}
