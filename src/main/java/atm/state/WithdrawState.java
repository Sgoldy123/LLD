package atm.state;

import atm.ATM;
import atm.Operation;
import atm.User;
import atm.dispenseChain.Dispense;
import atm.dispenseChain.DispenseFiveHundred;
import atm.dispenseChain.DispenseThoushand;
import atm.dispenseChain.HundredDispense;

import java.util.List;

public class WithdrawState implements State {

    @Override
    public void insertCard(User user, ATM atm) {
        throw  new IllegalStateException("Cant access");
    }

    @Override
    public void checkPin(User user, int pin, ATM atm) {
        throw  new IllegalStateException("Cant access");
    }

    @Override
    public void selectOperation(User user, Operation operation, ATM atm) {
        throw  new IllegalStateException("Cant access");
    }

    @Override
    public void depositAmount(User user, List<Integer> notes, ATM atm) {
        throw  new IllegalStateException("Cant access");
    }

    @Override
    public void withdrawAmount(User user, int amount, ATM atm) {
        if(user.getCard().getAccount().getBalance() < amount){
            System.out.println("Insufficient user balance");
            atm.setState(new IdleState());
            return;
        }
        if(amount>atm.atmBalance()){
            System.out.println("Atm has no money");
            atm.setState(new IdleState());
            return;
        }


        Dispense withdrawCash= new DispenseThoushand(new DispenseFiveHundred(new HundredDispense(null)));
        withdrawCash.callNext(atm,user,amount);
        atm.setState(new IdleState());

        System.out.println("state changed from  SelectOperationState to idleState");
    }
}
