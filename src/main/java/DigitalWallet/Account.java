package DigitalWallet;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Account {

    private String id;
    private String accountno;
    private BigDecimal amount;
    List<Transaction> transactions;

    public Account(String id, String accountno, BigDecimal amount) {
        this.id = id;
        this.accountno = accountno;
        this.amount = amount;
        this.transactions = new ArrayList<>();
    }

    public void withDrawAmount(BigDecimal drawAmount){
        amount.subtract(drawAmount);
    }
    public void depositAmount(BigDecimal depositamnt){
        amount.add(depositamnt);
    }
}
