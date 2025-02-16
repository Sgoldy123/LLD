package Linkedin;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCredential {


    private String userId;
    private String email;
    private String password;

    public LoginCredential(String userId, String email, String password) {
        this.userId = userId;
        this.email = email;
        this.password = password;
    }
}
