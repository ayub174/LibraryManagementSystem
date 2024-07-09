package models;

import java.util.ArrayList;
import java.util.List;

public class User {


    private String memberId, name;
    List<Book> borrowedBooks;
    private final boolean isAdmin;

    public User(String memberId, String name, boolean isAdmin)
    {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
        this.isAdmin = isAdmin;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public boolean isAdmin()
    {
        return isAdmin;
    }


}