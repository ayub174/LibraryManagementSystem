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


    /*
      1) Skapa en ny bok som du lägger till i listan
      2) använd delete metoden för att ta bort boken
      3) Verifiera att boken inte finns kvar.
     */

    @Test
    public void deleteBookFromTheBookList()
    {
        try{
            //create new book
            libraryService.addBook("1234", "The Alchemist", "Paulo Coelho", false);
            libraryService.deleteBook("1234");
            assertTrue(libraryService.books.isEmpty());
        }catch(Exception e)
        {
            throw new RuntimeException("Exception thrown");
        }
    }




}