package atm.dispenseChain;

import atm.ATM;
import atm.User;

public class HundredDispense extends Dispense {

    public  HundredDispense(Dispense hundredDispense){
        super(hundredDispense);
    }

    public void callNext(ATM atm, User user, int amount){
        //
        int existingHundredNotes=atm.getHunderNotes();
        int requiredNotes=amount/100;
        if(existingHundredNotes>=requiredNotes){
            amount=amount-requiredNotes*100;
            existingHundredNotes-=requiredNotes;
        }
        else{
            requiredNotes=existingHundredNotes;
            amount=amount-existingHundredNotes*100;
            existingHundredNotes=0;

        }
        atm.setHunderNotes(existingHundredNotes);
        user.getCard().getAccount().setBalance(user.getCard().getAccount().getBalance()-requiredNotes*100);

        System.out.println("hundred Notes: "+ requiredNotes+" - "+requiredNotes*100);

        if (amount!=0){
            super.callNext(atm,user,amount);
        }

    }
}
