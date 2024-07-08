public class TestConstantsUtility  {


    public static final String excpectedISBN = "1234";
    public static final String expectedTitle = "The Alchemist";
    public static final String expectedAuthor  = "Paulo Coelho";



    //Vill inte kunna instansiera denna klass
    private TestConstantsUtility()
    {
        throw new UnsupportedOperationException("Can´t instantiate this class, since its used as a utility class");
    }

}
