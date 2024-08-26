package Splitwise;

public class User {
    private String id;
    private Balance balance;

    public User(String id) {
        this.id = id;
        balance = new Balance();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }
}
