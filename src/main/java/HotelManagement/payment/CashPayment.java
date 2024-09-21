package HotelManagement.payment;

public class CashPayment implements Payment{
    @Override
    public boolean makePay() {
        System.out.println("Payment done with cash");
        return true;
    }
}
