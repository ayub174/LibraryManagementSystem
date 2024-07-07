package models;

public class Book {


    private String isbn, title, author;
    private boolean isBorrowed;

    public Book(String isbn, String title, String author, boolean isBorrowed)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String toString()
    {
        return "Book name: " + getTitle() + " Author: " + getAuthor();
    }

}