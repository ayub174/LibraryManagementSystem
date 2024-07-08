import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import services.LibraryService;
import models.Book;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTests {

    private LibraryService libraryService;




    @BeforeEach
    public void setUp()
    {
        List<Book> books = new ArrayList<>();
        libraryService = new LibraryService(books);
    }



    @Test
    void whenAddBookWithValidInputThenNoExceptionThrown() throws Exception
    {
        try{
            //create new book
            libraryService.addBook("1234", "The Alchemist", "Paulo Coelho", false);
        }catch(Exception e)
        {
          throw new RuntimeException("Exception thrown");
        }

        //check if the book we created is equal to the book in the list
        assertEquals(TestConstantsUtility.excpectedISBN, libraryService.books.get(0).getIsbn());
        assertEquals(TestConstantsUtility.expectedTitle, libraryService.books.get(0).getTitle());
        assertEquals(TestConstantsUtility.expectedAuthor, libraryService.books.get(0).getAuthor());
        assertFalse(libraryService.books.get(0).isBorrowed());


    }




}