package Linkedin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Profile profile;
    private LoginCredential loginCredential;
    private Post post;
    private Connection connection;
    private Message message;
    private Screen screen;
    public  User(){
        profile=new Profile();
        post=new Post();
        connection=new Connection();
        message=new Message();
        screen=new Screen(this);
    }

}
