package SocialNetwork;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Post {
    static int nextId = 1;
    int id;
    String content;
    User author;
    LocalDateTime timestamp;
    int upvotes;
    int downvotes;
    List<Reply> replies;

    public Post(String content, User author) {
        this.id = nextId++;
        this.content = content;
        this.author = author;
        this.timestamp = LocalDateTime.now();
        this.upvotes = 0;
        this.downvotes = 0;
        this.replies = new ArrayList<>();
    }

    public void upvote() {
        upvotes++;
    }

    public void downvote() {
        downvotes++;
    }

    public void reply(User user, String text) {
        replies.add(new Reply(text, user));
    }

    public int getScore() {
        return upvotes - downvotes;
    }
}
