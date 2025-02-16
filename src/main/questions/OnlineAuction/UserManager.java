package OnlineAuction;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

@Getter
@Setter
public class UserManager {

    private Map<String,User> users;
    private  UserManager(){
        users=new HashMap<>();
    }

    private static UserManager userManager=new UserManager();

    public static UserManager getInstance(){
        return userManager;
    }

    public User login(String userId,String password){
        if(users.containsKey(userId)){
            if(users.get(userId).getPassword().equals(password)){
                return users.get(userId);
            }
        }
        System.out.println("Userid and password are not matching");
        return null;
    }
    public User register(String userId,String password){
        if(users.containsKey(userId)){
            System.out.println("User already registered.");
            return null;
        }
        users.put(userId,new User(userId,password));

        return users.get(userId);
    }

    public void notifyAllUser(User userPlacedBid,Item item){
        for(Map.Entry<String,User> it:users.entrySet()){
            if(!it.getKey().equals(userPlacedBid.getUserId())){
                it.getValue().notifyUser(userPlacedBid.getUserId()+" placed a bid for "+ item.getItemid()+" price: "+item.getNewBidPrice());
            }
        }
    }


}
