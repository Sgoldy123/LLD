package atm.dispenseChain;

import atm.ATM;
import atm.User;

public class Dispense {

    private Dispense nextDispense;
    Dispense(Dispense nextDispense){
        this.nextDispense=nextDispense;
    }

    public void callNext(ATM atm, User user,int amount){
        if(nextDispense==null){

            System.out.println(" Something is wrong!! there is no next call !! ");
            return;
        }
        if(amount==0){
            System.out.println(" Amount Withdraw ");
            return;
        }
        nextDispense.callNext(atm,user,amount);
    }

}
