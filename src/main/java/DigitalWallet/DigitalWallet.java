package DigitalWallet;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class DigitalWallet {
    private static DigitalWallet digitalWallet;
    private Map<String,User> users;

    public DigitalWallet getInstance(){
        if(digitalWallet==null){
            digitalWallet=new DigitalWallet();
        }
        return digitalWallet;
    }

    DigitalWallet(){
        users=new HashMap<>();
    }

    public synchronized void transferAmount(Account source, Account des, BigDecimal amount,CurrencyType currencyType){
        //convert currenct if needed

        // depost withdraw amount from the account

        // add transaction to respective Account
    }


}
