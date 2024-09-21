package HotelManagement.customer;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CustomerManager {
    private List<Customer> customerList;
    public CustomerManager(){
        customerList=new ArrayList<>();
    }


    public Customer getCustomerById(String customerId){
        for(Customer customer:customerList){
            if(customer.getCustomerId().equals(customerId)){
                return customer;
            }
        }
        System.out.println("Customer not found with given customer id: "+customerId);
        return null;
    }
}
