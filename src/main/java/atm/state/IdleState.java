package atm.state;

import atm.ATM;
import atm.Operation;
import atm.User;

import java.util.List;

public class IdleState implements State{



    @Override
    public void insertCard(User user, ATM atm) {
          System.out.println("state changed from idle to HasCardState");
           atm.setState(new HasCardState());
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
    public void withdrawAmount(User user, int amoint, ATM atm) {
        throw  new IllegalStateException("Cant access");
    }


}
