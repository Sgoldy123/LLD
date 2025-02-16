package HotelManagement.payment;

public class MobilePayment implements Payment{

    @Override
    public boolean makePay() {
        System.out.println("Payment done with Mobile");
        return true;
    }
}
