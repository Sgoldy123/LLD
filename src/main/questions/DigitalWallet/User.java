package DigitalWallet;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User
{
    private String id;
    private String email;
    private List<Account> accountList;

    public User(String id, String email, List<Account> accountList) {
        this.id = id;
        this.email = email;
        this.accountList = accountList;
    }
}
