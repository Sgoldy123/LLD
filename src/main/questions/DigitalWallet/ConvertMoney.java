package DigitalWallet;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ConvertMoney {
    private static final Map<CurrencyType, BigDecimal> exchangeRates = new HashMap<>();

    static {
        // Initialize exchange rates
        exchangeRates.put(CurrencyType.RS,new BigDecimal(1));
        // Add more exchange rates as needed
    }
    public BigDecimal convertMoney(BigDecimal amount,CurrencyType sourceCurrency, CurrencyType desCurrency){
         return new BigDecimal(1);
    }
}
