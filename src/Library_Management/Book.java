package Library_Management;

public class Book {
    private Integer bookId;
    private Integer rackId;
    private String title;
    private String author;
    private String publisher;
    private boolean isBorrowed;

    public Book(Integer bookId, String title, String author, String publisher) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isBorrowed = false;
    }
    public void setRackId(Integer rackId){
        this.rackId = rackId;
    }
    public void setBorrowed(boolean isBorrowed){
        this.isBorrowed = isBorrowed;
    }

    public Integer getBookId() {
        return bookId;
    }

    public Integer getRackId() {
        return rackId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}
