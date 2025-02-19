package SocialNetwork;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class User {
    String username;
    Set<User> following;
    List<Post> posts;

    public User(String username) {
        this.username = username;
        this.following = new HashSet<>();
        this.posts = new ArrayList<>();
    }

    public void follow(User user) {
        following.add(user);
    }

    public Post post(String content) {
        Post post = new Post(content, this);
        posts.add(post);
        return post;
    }
}
