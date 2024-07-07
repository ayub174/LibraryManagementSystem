package services;

import models.Book;

import java.util.List;

//Logic handler for library services
public class LibraryService {


    public List<Book> books;


    public LibraryService(List<Book> books) {
        this.books = books;
    }


    //Adding a new book to the LMS
    public void addBook(String isbn, String title, String author, boolean isBorrowed) throws Exception {
        checkIfBookExists(isbn);
        validateBookDetails(isbn, title, author);
        Book book = new Book(isbn, title, author, isBorrowed);
        books.add(book);
    }




    //Delete book
    public void deleteBook(String isbn)
    {
       books.removeIf(b->b.getIsbn().equalsIgnoreCase(isbn));
    }

    //Update book info
    public void updateBook(String isbn, String title, String author, boolean isBorrowed)
    {
        for(Book b : books)
        {
            if(b.getIsbn().equalsIgnoreCase(isbn))
            {
                b.setTitle(title);
                b.setAuthor(author);
                b.setBorrowed(isBorrowed);
            }
        }
    }

    //Add member


    //Remove member


    //Borrow book


    //Return book


    //Show all books
    public void showAllBooks(){
        for(Book b : books)
        {
            System.out.println(b.toString());
        }
    }

    //Show all members



    public void checkIfBookExists(String isbn) throws Exception
    {
        for(Book b : books)
        {
            if(b.getIsbn().equalsIgnoreCase(isbn))
            {
                throw new Exception("This book already exists. Please add a new book. ");
            }
        }
    }


    public void validateBookDetails(String isbn, String title, String author)
    {
        if(isbn == null || isbn.isEmpty())
        {
            throw new IllegalArgumentException("ISBN can´t be empty. ");
        }

        if(title == null || title.isEmpty())
        {
            throw new IllegalArgumentException("Title can´t be empty. ");
        }

        if(author == null ||author.isEmpty())
        {
            throw new IllegalArgumentException("Author can´t be empty. ");
        }
    }


}
