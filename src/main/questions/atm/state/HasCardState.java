package atm.state;

import atm.ATM;
import atm.Operation;
import atm.User;

import java.util.List;

public class HasCardState implements State {

    @Override
    public void insertCard(User user, ATM atm) {
        throw  new IllegalStateException("Cant access");
    }

    @Override
    public void checkPin(User user, int pin, ATM atm) {
        if(pin==user.getCard().getPin()){
            System.out.println("state changed from  HasCardState to SelectOperationState");
            atm.setState(new SelectOperationState());
        }
        else{
            System.out.println("Pin is incorrect!!");
            System.out.println("state changed from  HasCardState to idle");
            atm.setState(new IdleState());
        }
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
    public void withdrawAmount(User user, int amoint, ATM atm) {
        throw  new IllegalStateException("Cant access");
    }
}
