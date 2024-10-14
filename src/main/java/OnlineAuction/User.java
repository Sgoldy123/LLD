package OnlineAuction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String userId;
    private String password;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public void notifyUser(String s){
        System.out.println(userId+": "+s);
    }
}
