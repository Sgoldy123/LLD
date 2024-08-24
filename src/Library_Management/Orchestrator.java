package Library_Management;

import java.util.ArrayList;
import java.util.List;

public class Orchestrator {
    public static void main(String[] args) {
        //create Library
        Library library = new Library();
        LibraryManager libraryManager = new LibraryManager(library);

        //add racks
        Rack rack1 = new Rack(1,3);
        Rack rack2 = new Rack(2,3);
        libraryManager.addRack(rack1);
        library.printAllFields();
        libraryManager.addRack(rack2);
        library.printAllFields();

        //add books to Library
        Book book1 = new Book(1,"a","a","a");
        Book book2 = new Book(2,"b","a","b");
        Book book3 = new Book(3,"b","c","a");
        Book book4 = new Book(4,"d","b","c");
        Book book5 = new Book(5,"a","b","c");

        List<Book> bookList = new ArrayList<>(List.of(book1,book2,book3,book4,book5));
        for(Book book : bookList){
            libraryManager.addBook(book);
            library.printAllFields();
        }

        //remove a book copy from library
        libraryManager.removeBookCopy("a","a","a");
        library.printAllFields();

        //User creation
        User user1 = new User(1,"user-1");
        User user2 = new User(2,"user-2");
        User user3 = new User(3,"user-3");
        //add user
        List<User> userList = new ArrayList<>(List.of(user1,user2,user3));
        for(User user : userList){
            libraryManager.addUser(user.getUserId(),user);
            library.printAllFields();
        }



        //borrow a book copy
        libraryManager.borrowBookACopy("a","b","c",user1);
        library.printAllFields();

        //return book
        libraryManager.returnBook(5);
        library.printAllFields();

        //print all borrowed books by user
        libraryManager.getAllBorrowedBooks(1);
        library.printAllFields();



    }
}
