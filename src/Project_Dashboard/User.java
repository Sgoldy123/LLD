package Project_Dashboard;

import java.util.UUID;

public class User {
    private String userId;
    private String mail = null;
    private String name;
    public User(String name){
        this.userId = "userId_" + UUID.randomUUID().toString();
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }
}
