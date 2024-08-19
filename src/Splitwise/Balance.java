package Splitwise;

import java.util.HashMap;
import java.util.Map;

public class Balance {
    Map<User,Double> getback ;
    Map<User,Double> give;

    public Balance() {
        this.getback = new HashMap<>();
        this.give = new HashMap<>();
    }

    public Map<User, Double> getGetback() {
        return getback;
    }

    public Map<User, Double> getGive() {
        return give;
    }
}
