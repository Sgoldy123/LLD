package atm.state;

import atm.ATM;
import atm.Operation;
import atm.User;

import java.util.List;

public class DepositState implements State {
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
        int totAmount=notes.get(0)*1000+notes.get(1)*500+notes.get(2)*100;
        atm.setThousandNotes(atm.getThousandNotes()+notes.get(0));
        atm.setFiveHundredNotes(atm.getFiveHundredNotes()+notes.get(1));
        atm.setHunderNotes(atm.getHunderNotes()+notes.get(2));
        user.getCard().getAccount().setBalance( user.getCard().getAccount().getBalance()+totAmount);
        atm.setState(new IdleState());
    }

    @Override
    public void withdrawAmount(User user, int amoint, ATM atm) {
        throw  new IllegalStateException("Cant access");
    }
}
