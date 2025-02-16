package HotelManagement.payment;

public class PaymentFactory {

    public Payment getPaymentWithType(PaymentType paymentType ){
        if (paymentType==PaymentType.Cash){
            return new CashPayment();
        }
        else if(paymentType==PaymentType.CreditCard){
            return new CreditCardPayment();
        }

        return new MobilePayment();
    }
}
