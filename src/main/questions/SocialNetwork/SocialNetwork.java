package SocialNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SocialNetwork {
    Map<String, User> users;
    User currentUser;

    public SocialNetwork() {
        this.users = new HashMap<>();
        this.currentUser = null;
    }

    public void signup(String username) {
        if (users.containsKey(username)) {
            System.out.println("User already exists.");
        } else {
            users.put(username, new User(username));
            System.out.println("User " + username + " signed up.");
        }
    }

    public void login(String username) {
        if (users.containsKey(username)) {
            currentUser = users.get(username);
            System.out.println("User " + username + " logged in.");
        } else {
            System.out.println("User not found.");
        }
    }

    public void post(String content) {
        if (currentUser != null) {
            Post post = currentUser.post(content);
            System.out.println("Post created with ID: " + post.id);
        } else {
            System.out.println("No user logged in.");
        }
    }

    public void follow(String username) {
        if (currentUser != null) {
            User userToFollow = users.get(username);
            if (userToFollow != null) {
                currentUser.follow(userToFollow);
                System.out.println("You are now following " + username);
            } else {
                System.out.println("User not found.");
            }
        } else {
            System.out.println("No user logged in.");
        }
    }

    public void upvote(int postId) {
        if (currentUser != null) {
            Post post = findPostById(postId);
            if (post != null) {
                post.upvote();
                System.out.println("Post " + postId + " upvoted.");
            } else {
                System.out.println("Post not found.");
            }
        } else {
            System.out.println("No user logged in.");
        }
    }

    public void downvote(int postId) {
        if (currentUser != null) {
            Post post = findPostById(postId);
            if (post != null) {
                post.downvote();
                System.out.println("Post " + postId + " downvoted.");
            } else {
                System.out.println("Post not found.");
            }
        } else {
            System.out.println("No user logged in.");
        }
    }

    public void reply(int postId, String text) {
        if (currentUser != null) {
            Post post = findPostById(postId);
            if (post != null) {
                post.reply(currentUser, text);
                System.out.println("Reply added to post " + postId);
            } else {
                System.out.println("Post not found.");
            }
        } else {
            System.out.println("No user logged in.");
        }
    }

    public void showNewsFeed() {
        if (currentUser != null) {
            List<Post> allPosts = new ArrayList<>();
            for (User user : currentUser.following) {
                allPosts.addAll(user.posts);
            }
            allPosts.addAll(currentUser.posts);

            // Sort posts based on criteria
            allPosts.sort((p1, p2) -> {
                if (currentUser.following.contains(p1.author) && !currentUser.following.contains(p2.author)) return -1;
                if (!currentUser.following.contains(p1.author) && currentUser.following.contains(p2.author)) return 1;
                if (p1.getScore() != p2.getScore()) return p2.getScore() - p1.getScore();
                if (p1.replies.size() != p2.replies.size()) return p2.replies.size() - p1.replies.size();
                return p2.timestamp.compareTo(p1.timestamp);
            });

            // Display posts
            for (Post post : allPosts) {
                System.out.println("id: " + post.id);
                System.out.println("(" + post.upvotes + " upvotes, " + post.downvotes + " downvotes)");
                System.out.println(post.author.username);
                System.out.println(post.content);
                System.out.println(post.timestamp);
                System.out.println();
            }
        } else {
            System.out.println("No user logged in.");
        }
    }

    private Post findPostById(int postId) {
        for (User user : users.values()) {
            for (Post post : user.posts) {
                if (post.id == postId) {
                    return post;
                }
            }
        }
        return null;
    }
}
