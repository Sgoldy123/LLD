package atm.state;

import atm.ATM;
import atm.Operation;
import atm.User;

import java.util.List;

public interface State {


    public void insertCard(User user, ATM atm);    //idle state

    public void checkPin(User user,int pin,ATM atm);  //has card state

    public void selectOperation(User user, Operation operation, ATM atm);  // operation State

    public  void depositAmount(User user, List<Integer> notes, ATM atm);  // Deposit state

    public  void withdrawAmount(User user, int amoint, ATM atm);  // Deposit state
}
