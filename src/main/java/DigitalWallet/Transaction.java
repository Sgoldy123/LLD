package DigitalWallet;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class Transaction {

    private String id;
    private Account sourceAccount;
    private Account desAccount;
    private CurrencyType currencyType;
    private BigDecimal transferredAmount;

    public Transaction(String id, Account sourceAccount, Account desAccount, CurrencyType currencyType, BigDecimal transferredAmount) {
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.desAccount = desAccount;
        this.currencyType = currencyType;
        this.transferredAmount = transferredAmount;
    }
}
