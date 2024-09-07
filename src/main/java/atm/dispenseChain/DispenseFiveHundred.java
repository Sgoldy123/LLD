package atm.dispenseChain;

import atm.ATM;
import atm.User;

public class DispenseFiveHundred extends Dispense{

    public DispenseFiveHundred(Dispense hundredDispense){
        super(hundredDispense);
    }


    public void callNext(ATM atm, User user, int amount){
        //
        int existingFiveHundredNotes=atm.getFiveHundredNotes();
        int requiredNotes=amount/500;
        if(existingFiveHundredNotes>=requiredNotes){
            amount=amount-requiredNotes*500;
            existingFiveHundredNotes-=requiredNotes;
        }
        else{
            requiredNotes=existingFiveHundredNotes;
            amount=amount-existingFiveHundredNotes*500;
            existingFiveHundredNotes=0;

        }
        atm.setFiveHundredNotes(existingFiveHundredNotes);
        user.getCard().getAccount().setBalance(user.getCard().getAccount().getBalance()-requiredNotes*500);

        System.out.println("FiveHundred Notes: "+ requiredNotes+" - "+requiredNotes*500);

        if (amount!=0){
            super.callNext(atm,user,amount);
        }

    }
}
