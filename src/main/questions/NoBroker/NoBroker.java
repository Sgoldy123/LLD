package NoBroker;

import java.util.*;

public class NoBroker {
    public static void main(String[] args) {
        PropertyHuntSystem system = new PropertyHuntSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("→ ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command) {
                case "Register":
                    system.register(parts[1]);
                    break;
                case "Login":
                    system.login(parts[1]);
                    break;
                case "Logout":
                    system.logout();
                    break;
                case "ListProperty":
                    System.out.println("← Enter the property details:");
                    System.out.print("→ ");
                    String details = scanner.nextLine();
                    // Parse details and call system.listProperty(...)
                    break;
                case "Search":
                    // Parse search parameters and call system.search(...)
                    break;
                case "Shortlist":
                    system.shortlistProperty(Integer.parseInt(parts[1]));
                    break;
                case "ViewShortlisted":
                    system.viewShortlisted();
                    break;
                case "ViewListed":
                    system.viewListed();
                    break;
                case "MarkSold":
                    system.markSold(Integer.parseInt(parts[1]));
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}