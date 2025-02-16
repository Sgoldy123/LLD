package Library_Management;

import java.util.*;

public class Library {
    private Map<Integer,Book> bookMap;
    private Map<String,Borrow> borrowMap;
    private Map<Integer,User> userMap;
    private Map<Integer,Rack> rackMap;

    public Library() {
        this.bookMap = new TreeMap<>();
        this.borrowMap = new TreeMap<>();
        this.userMap = new TreeMap<>();
        this.rackMap = new TreeMap<>();
    }


    public Map<Integer, Book> getBookMap() {
        return bookMap;
    }

    public Map<String, Borrow> getBorrowMap() {
        return borrowMap;
    }

    public Map<Integer, User> getUserMap() {
        return userMap;
    }

    public Map<Integer, Rack> getRackMap() {
        return rackMap;
    }

    public void printAllFields() {
        System.out.println("Books:");
        bookMap.forEach((key, book) -> System.out.println("Book ID: " + book.getBookId() +
                ", Rack ID: " + book.getRackId() +
                ", Title: " + book.getTitle() +
                ", Author: " + book.getAuthor() +
                ", Publisher: " + book.getPublisher() +
                ", Is Borrowed: " + book.isBorrowed()));

        System.out.println("\nBorrows:");
        borrowMap.forEach((key, borrow) -> System.out.println("Borrow ID: " + borrow.getBorrowId() +
                ", Book ID: " + borrow.getBookId() +
                ", User ID: " + borrow.getUserId() +
                ", Due Date: " + borrow.getDewDate()));

        System.out.println("\nUsers:");
        userMap.forEach((key, user) -> {
            System.out.println("User ID: " + user.getUserId() + ", Name: " + user.getUserName());
            System.out.println("Borrowed Books:");
            user.getBorrowList().forEach(borrow -> System.out.println("   Borrow ID: " + borrow.getBorrowId() +
                    ", Book ID: " + borrow.getBookId() +
                    ", Due Date: " + borrow.getDewDate()));
        });

        System.out.println("\nRacks:");
        rackMap.forEach((key, rack) -> {
            System.out.println("Rack ID: " + rack.getRackId() + ", Rack Size: " + rack.getRackSize() +
                    ", Is Full: " + rack.isFull());
            System.out.println("Books on this Rack:");
            rack.getBookMap().forEach((bookKey, book) -> System.out.println("   Book ID: " + book.getBookId() +
                    ", Title: " + book.getTitle()));
        });
        System.out.println("************************************************NEW OUTPUT**************************************************************");
    }
}
