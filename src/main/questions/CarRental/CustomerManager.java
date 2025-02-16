package CarRental;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class CustomerManager {
    private List<Customer> customerList;
    private static CustomerManager customerManager=new CustomerManager();
    private CustomerManager(){
        customerList=new ArrayList<>();
    }
    public static CustomerManager getInstance(){
        return  customerManager;
    }


}
