package SocialNetwork;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            String[] parts = input.split("~");
            String command = parts[0];

            switch (command) {
                case "signup":
                    network.signup(parts[1]);
                    break;
                case "login":
                    network.login(parts[1]);
                    break;
                case "post":
                    network.post(parts[1]);
                    break;
                case "follow":
                    network.follow(parts[1]);
                    break;
                case "upvote":
                    network.upvote(Integer.parseInt(parts[1]));
                    break;
                case "downvote":
                    network.downvote(Integer.parseInt(parts[1]));
                    break;
                case "reply":
                    network.reply(Integer.parseInt(parts[1]), parts[2]);
                    break;
                case "shownewsfeed":
                    network.showNewsFeed();
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}