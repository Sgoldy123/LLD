package Library_Management;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private Integer userId;
    private String userName;

    private List<Borrow> borrowList;

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public List<Borrow> getBorrowList() {
        return borrowList;
    }

    public User(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.borrowList = new ArrayList<Borrow>();
    }

    public void addBorrow(Integer bookId, Date dewDate){
        if(borrowList.size()<5) {
            Borrow borrow = new Borrow(bookId, userId, dewDate);
            borrowList.add(borrow);

        }
        else{
            System.out.println("Can't borrow more than 5 books");
        }

    }
}
