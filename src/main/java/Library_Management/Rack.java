package Library_Management;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Rack {
    private Integer rackId;
    private Integer rackSize;
    private Map<Integer,Book> bookMap;

    private boolean isFull;

    public Rack(Integer rackId, Integer rackSize) {
        this.rackId = rackId;
        this.rackSize = rackSize;
        this.bookMap = new TreeMap<>();
        this.isFull = false;
    }

    public Integer getRackId() {
        return rackId;
    }

    public Integer getRackSize() {
        return rackSize;
    }

    public Map<Integer, Book> getBookMap() {
        return bookMap;
    }

    public boolean isFull() {
        return isFull;
    }

    public void addBook(Book book) {
        for(int i=0;i<rackSize;i++){
            if(!bookMap.containsKey(i)){
                bookMap.put(i,book);
                book.setRackId(rackId);
                if(bookMap.size() == rackSize)isFull=true;
                break;
            }
        }
        return;
    }

    public void removeBookCopy(Book removeBook) {
        bookMap.remove(removeBook.getBookId());
        if(rackSize.compareTo(bookMap.size())>0)isFull = false;
    }
}
