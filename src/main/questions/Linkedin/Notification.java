package Linkedin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Notification {
    private List<String> notifications;

    public Notification(){
        notifications=new ArrayList<>();
    }

    public void addNotification(String msg){
        String notify=""+new Date()+" ---" +msg;
        notifications.add(notify);
    }
}
