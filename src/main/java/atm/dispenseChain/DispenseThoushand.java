package atm.dispenseChain;

import atm.ATM;
import atm.User;

public class DispenseThoushand extends Dispense{

    public  DispenseThoushand(Dispense fiveHundreDispense){
        super(fiveHundreDispense);
    }

    public void callNext(ATM atm, User user,int amount){
        //
        int existing1000HundredNotes=atm.getThousandNotes();
        int requiredNotes=amount/1000;
        if(existing1000HundredNotes>=requiredNotes){
            amount=amount-requiredNotes*1000;
            existing1000HundredNotes-=requiredNotes;
        }
        else{
            requiredNotes=existing1000HundredNotes;
            amount=amount-existing1000HundredNotes*1000;
            existing1000HundredNotes=0;

        }
        atm.setThousandNotes(existing1000HundredNotes);
        user.getCard().getAccount().setBalance(user.getCard().getAccount().getBalance()-requiredNotes*1000);

        System.out.println("Thousand Notes: "+ requiredNotes+" - "+requiredNotes*1000);

        if (amount!=0){
            super.callNext(atm,user,amount);
        }

    }


}
