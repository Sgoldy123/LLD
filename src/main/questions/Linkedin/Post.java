package Linkedin;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Post {

    private List<String> posts;

    public Post(){
        posts=new ArrayList<>();
    }

    public void createPost(String title,String desc,String req,String loc,String postdBy){
        String post="PostedBy: "+postdBy+" Title: "+title+" Description: "+desc+" Requirementd: "
                +req+" Location: "+loc;
        posts.add(post);
    }

}
