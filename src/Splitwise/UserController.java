package Splitwise;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    private List<User> userList;

    private static UserController userController=new UserController();

    private UserController(){
        userList=new ArrayList<>();
    }

    public  static UserController getUserController(){
        return userController;
    }

    public List<User> getUserList(){
        return userList;
    }

//    public User getUser(String id){
//        ///
//
//    }
    public void addUser(User user){
        userList.add(user);
    }
}
