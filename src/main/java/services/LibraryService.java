package services;

import models.Book;
import models.User;

import java.util.List;

//Service layer for LMS
public class LibraryService {


    public List<Book> books;
    public List<User> users;

    public LibraryService(List<Book> books, List<User> users) {
        this.books = books;
        this.users = users;
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

    //Add member: Admin should be able to add a member to the LMS. Without being a member, you cannot borrow any books.
    public void addUser(User admin, String memberId, String name, boolean isAdmin) throws IllegalArgumentException
    {
        if(admin.isAdmin())
        {
            User user = new User(memberId, name, isAdmin);
            users.add(user);
        }else{
            throw new IllegalArgumentException("You are not an admin.");
        }

    }



    //Remove member


    public void borrowBook(String memberId, String isbn)
    {
        //Vill kolla att boken inte är låand av någon annan
        for(Book book : books)
        {
            if(book.getIsbn().equalsIgnoreCase(isbn) && !book.isBorrowed())
            {
                for(User user : users)
                {
                    if(user.getMemberId().equalsIgnoreCase(memberId))
                    {
                        user.getBorrowedBooks().add(book);
                        book.setBorrowed(true);
                    }
                }
            }
        }

    }
    //Return book
    public void returnBook(String memberId, String isbn)
    {

        User user = findUserById(memberId);

       if(user == null)
       {
           throw new IllegalArgumentException("User not found");
       }

       Book bookToReturn = null;

        for(Book book : user.getBorrowedBooks())
        {
            if(book.getIsbn().equalsIgnoreCase(isbn))
            {
                book.setBorrowed(false);
                bookToReturn = book;
                break;
            }
        }

        if(bookToReturn == null)
        {
            throw new IllegalArgumentException("Book not found");
        }


        bookToReturn.setBorrowed(false);
        user.getBorrowedBooks().remove(bookToReturn);

    }

    private User findUserById(String memberId) {
        User u = null;
        for(User user : users)
        {
            if(user.getMemberId().equalsIgnoreCase(memberId));
            u = new User(user.getMemberId(), user.getName(), user.isAdmin());
        }
        return u;
    }


    //Show all books
    public void showAllBooks(){
        for(Book b : books)
        {
            System.out.println(b.toString());
        }
    }

    //Show all members
    public void showAllMembers()
    {
        for(User u : users)
        {
            System.out.println(u.getName());
        }
    }


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
