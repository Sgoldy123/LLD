package atm.state;

import atm.ATM;
import atm.Operation;
import atm.User;

import java.util.List;

public class SelectOperationState implements State {
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
         if(operation==Operation.INQUERY){
                System.out.println("state changed from SelectOperationState to inquiryState");
                System.out.println("Balance is: "+ user.getCard().getAccount().getBalance());
         }
          else if(operation==Operation.DEPOSIT){
             System.out.println("state changed from SelectOperationState to DepositState");
              atm.setState(new DepositState());
          }
          else{
             System.out.println("state changed from SelectOperationState to WithdrawState");
              atm.setState(new WithdrawState());
          }
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
