package Library_Management;

import java.util.Date;
import java.util.UUID;

public class Borrow {
    private String borrowId;
    private Integer bookId;

    private Integer userId;
    private Date dewDate;

    public Borrow(Integer bookId,Integer userId, Date dewDate) {
        this.borrowId = UUID.randomUUID().toString();
        this.bookId = bookId;
        this.userId = userId;
        this.dewDate = dewDate;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Date getDewDate() {
        return dewDate;
    }


}
