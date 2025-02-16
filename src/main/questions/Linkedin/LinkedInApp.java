package Linkedin;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class LinkedInApp
{
    public static void main(String[] args) {


    RegistrationLogin registrationLogin=RegistrationLogin.getInstance();

    User user1= registrationLogin.register("user1","user1@gmail.com","12345");
    User user2= registrationLogin.register("user2","user2@gmail.com","12345");

    user1.getConnection().addConnection(user1.getLoginCredential().getUserId(),user2.getLoginCredential().getUserId());

    user1.getPost().createPost("First Post","checking post display function","NA","NA",user1.getLoginCredential().getUserId());


    user2.getScreen().posts(registrationLogin);


    }
}
