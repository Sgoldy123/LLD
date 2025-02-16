package Linkedin;

import java.util.List;

public class Screen {
    private User user;
    public Screen(User user){
        this.user=user;
    }

    // display posts
    public void posts(RegistrationLogin registrationLogin){
        // user ownn posts
        for(String post: user.getPost().getPosts()){
            System.out.println(post);
        }

        //other user posts;
        List<String> connections=user.getConnection().getConnections();
        for(String userId:connections){
            List<String> posts=registrationLogin.getUserMap().get(userId).getPost().getPosts();
            for(String post:posts){
                System.out.println(post);
            }
        }

    }
}
