package Linkedin;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Message {
    private Map<String, List<String>> chats;
    public Message(){
        chats=new HashMap<>();
    }

    public void sendMessage(String fromUser,String toUser,String msg){
        String chatMsg="from-"+fromUser+" to-"+toUser+"---"+msg;
        // add chat msg to user 1
        if(!chats.containsKey(toUser)){
                chats.put(toUser,new ArrayList<>());
        }
        chats.get(toUser).add(chatMsg);


        // add chat msg to user 2;
        Map<String,List<String>> chatsUser2=RegistrationLogin.getInstance().getUserMap().get(toUser).getMessage().getChats();
        if(!chatsUser2.containsKey(fromUser)){
            chatsUser2.put(fromUser,new ArrayList<>());
        }
        chatsUser2.get(fromUser).add(chatMsg);
    }
}
