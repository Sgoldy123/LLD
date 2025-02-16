package Linkedin;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Connection {
    private List<String> connections;
    public Connection(){
        connections=new ArrayList<>();
    }

    public void addConnection(String sendReqUser,String userId){
        System.out.println(sendReqUser+" - "+userId);
        connections.add(userId);
        RegistrationLogin registrationLogin=RegistrationLogin.getInstance();
        User user=registrationLogin.getUserMap().get(userId);
        System.out.println(user);
        user.getConnection().getConnections().add(sendReqUser);
    }

    public void removeConnection(String userId){
        int idx=0;
        for(String user:connections){
            if (user.equals(userId)){
                break;
            }
            idx++;
        }
        connections.remove(idx);
    }

}
