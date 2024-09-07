package atm;

import atm.state.IdleState;
import atm.state.State;

public class AtmMachine {
    public static void main(String[] args) {
        Account account=Account.builder().balance(10000).build();
        Card card=Card.builder().cardNum(12345678).pin(1234).account(account).build();
        User user =User.builder().userId("user1").card(card).build();


        ATM atm=ATM.builder().thousandNotes(2).hunderNotes(5).fiveHundredNotes(3).state(new IdleState()).build();

        // operation
        State state=atm.getState();
        state.insertCard(user,atm);


        state=atm.getState();
        state.checkPin(user,1234,atm);

        state=atm.getState();
//        state.selectOperation(user,Operation.INQUERY,atm);
        state.selectOperation(user,Operation.WITHDRAW,atm);


        state=atm.getState();
        state.withdrawAmount(user,3800,atm);


        System.out.println("user balance: "+ user.getCard().getAccount().getBalance());
        System.out.println("atm balance: "+ atm.atmBalance());





    }



}
