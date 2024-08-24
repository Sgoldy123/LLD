package Library_Management;

import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

public class LibraryManager {
    private Library library;

    public LibraryManager(Library library) {
        this.library = library;
    }

    public void addUser(Integer userId, User user) {
        library.getUserMap().put(userId, user);
    }

    public void addRack(Rack rack) {
        library.getRackMap().put(rack.getRackId(), rack);
    }

    public void addBorrow(String borrowId, Borrow borrow) {
        library.getBorrowMap().put(borrowId, borrow);
    }

    public void addBook(Book book) {
        library.getBookMap().put(book.getBookId(), book);
        Rack rack = getFreeRack();
        if (rack != null) {
            rack.addBook(book);
        } else {
            System.out.println("No free racks available");
        }
    }

    public void removeBookCopy(String title, String author, String publisher) {
        Book removeBook = null;
        for (Map.Entry<Integer, Book> entry : library.getBookMap().entrySet()) {
            Book temp = entry.getValue();
            if (temp.getTitle().equals(title) && temp.getAuthor().equals(author) && temp.getPublisher().equals(publisher)) {
                removeBook = temp;
                break;
            }
        }

        if (removeBook != null) {
            library.getBookMap().remove(removeBook.getBookId());
            Rack removeFromRack = library.getRackMap().get(removeBook.getRackId());
            if (removeFromRack != null) {
                removeFromRack.removeBookCopy(removeBook);
            }
        }
    }

    public void borrowBookACopy(String title, String author, String publisher, User user) {
        Book borrowBook = null;
        for (Map.Entry<Integer, Book> entry : library.getBookMap().entrySet()) {
            Book temp = entry.getValue();
            if (temp.getTitle().equals(title) && temp.getAuthor().equals(author) && temp.getPublisher().equals(publisher)) {
                borrowBook = temp;
                break;
            }
        }

        if (borrowBook != null && !borrowBook.isBorrowed() && user.getBorrowList().size()<5) {
            borrowBook.setBorrowed(true);
            // Remove from rack
            Rack removeFromRack = library.getRackMap().get(borrowBook.getRackId());
            if (removeFromRack != null) {
                removeFromRack.removeBookCopy(borrowBook);
            }

            // Create borrow
            Borrow borrow = new Borrow(borrowBook.getBookId(),user.getUserId(), new Date());
            user.getBorrowList().add(borrow);
            library.getBorrowMap().put(borrowBook.getBookId().toString(), borrow);
        } else {
            System.out.println("Book is either not available or already borrowed.");
        }
    }


    public void returnBook(Integer bookId) {
        Book returnBook = null;
        for (Map.Entry<Integer, Book> entry : library.getBookMap().entrySet()) {
            Book temp = entry.getValue();
            if (temp.getBookId().equals(bookId)) {
                returnBook = temp;
                break;
            }
        }
        if (returnBook != null && returnBook.isBorrowed()) {
            returnBook.setBorrowed(false);
            // Add from rack
            Rack addToRack = getFreeRack();
            addToRack.addBook(returnBook);

            // remove borrow
            Borrow borrow = null;
            for(Map.Entry<String,Borrow> i : library.getBorrowMap().entrySet()){
                if(i.getValue().getBookId().equals(bookId)){
                    borrow = i.getValue();

                }
            }
            if(borrow != null) {
                library.getBorrowMap().remove(borrow.getBorrowId());
                library.getUserMap().get(borrow.getUserId()).getBorrowList().remove(borrow);
            }
        } else {
            System.out.println("Book is either returned already");
        }
    }

    public Rack getFreeRack() {
        for (Map.Entry<Integer, Rack> entry : library.getRackMap().entrySet()) {
            Rack temp = entry.getValue();
            if (!temp.isFull()) {
                return temp;
            }
        }
        return null;
    }

    public void getAllBorrowedBooks(Integer userId) {
        library.getUserMap().get(userId)
                .getBorrowList()
                .stream()
                .forEach(borrow -> System.out.println(
                        borrow.getBorrowId() + " " +
                                borrow.getBookId() + " " +
                                borrow.getUserId() + " " +
                                borrow.getDewDate()));
    }

}
