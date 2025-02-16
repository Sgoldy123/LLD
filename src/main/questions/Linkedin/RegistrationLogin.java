package Linkedin;

import CarRental.Booking;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class RegistrationLogin {
    private Map<String, User> userMap;
    private static RegistrationLogin registrationLogin=new RegistrationLogin();
    private RegistrationLogin(){
        userMap=new HashMap<>();
    }

    public static  RegistrationLogin getInstance(){
        return registrationLogin;
    }


    public User login(String userId, String password){
        if(!userMap.containsKey(userId)){
            System.out.println("you need to register first before login!!");
            return null;
        }
        User user=userMap.get(userId);
        if(!user.getLoginCredential().getPassword().equals(password)){
            System.out.println("username & password is not correct!!");
            return null;

        }
        return user;

    }

    public User register(String userId,String email,String password){
        if(userMap.containsKey(userId)){
            System.out.println("user is already present!!");
        }
        User user=new User();
        user.setLoginCredential(new LoginCredential(userId,email,password));
        userMap.put(userId,user);
        return user;
    }

}
