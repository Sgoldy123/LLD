package HotelManagement.payment;

public class CreditCardPayment implements Payment{
    @Override
    public boolean makePay() {
        System.out.println("Payment done with Credit Card");
        return true;
    }
}
