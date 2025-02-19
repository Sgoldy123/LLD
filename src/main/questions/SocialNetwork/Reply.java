package SocialNetwork;

import java.time.LocalDateTime;

class Reply {
    String text;
    User author;
    LocalDateTime timestamp;

    public Reply(String text, User author) {
        this.text = text;
        this.author = author;
        this.timestamp = LocalDateTime.now();
    }
}
