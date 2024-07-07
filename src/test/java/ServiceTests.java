import org.junit.Before;
import org.junit.Test;
import services.LibraryService;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTests {

    private LibraryService libraryService;



    @Before
    public void setUp()
    {
        libraryService = new LibraryService();

    }



    @Test
    public void whenAddBookWithValidInput_thenNoExceptionThrown()
    {
        try{
            //create new book
            libraryService.addBook("1234", "The Alchemist", "Paulo Coelho", false);
        }catch(Exception e)
        {
            e.printStackTrace();
            fail("Exception thrown");
        }

        //check if the book we created is equal to the book in the list
        assertEquals("1234", libraryService.books.get(0).getIsbn());
        assertEquals("The Alchemist", libraryService.books.get(0).getTitle());
        assertEquals("Paulo Coelho", libraryService.books.get(0).getAuthor());
        assertFalse(libraryService.books.get(0).isBorrowed());

    }




}