import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;


public class BookTest
{
    @Before
    public void init()
    {
        Book.resetId();
    }

    @After
    public void finalize()
    {
    }

    @Test
    public void testAuthorIsNull()
    {
        Book res = Book.make(null, "title", 10, "EDUCATIONAL");
        //assertEquals(elvárt érték, tényleges érték);
        assertEquals(null, res);
    }

    @Test
    public void testTitleIsNull()
    {
        Book res = Book.make("author", null, 10, "EDUCATIONAL");
        assertEquals(null, res);
    }

    @Test
    public void testTitleContaionsSpecChar()
    {
        Book res = Book.make("author", "title@f", 10, "EDUCATIONAL");
        assertEquals(null, res);
    }

    @Test
    public void testPrice()
    {
        Book book = Book.make("author", "titlef", 20, "EDUCATIONAL");
        assertEquals(20, book.getPrice());
    }

    @Test
    public void testBookId()
    {
        Book book1 = Book.make("author", "titlef", 10, "EDUCATIONAL"); // id = 0
        Book book2 = Book.make("author", "titlef", 10, "EDUCATIONAL"); // id = 1
        assertEquals(0, book1.getId());
        assertEquals(1, book2.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMake2InvalidArg()
    {
        Book.make2("author", "t", Book.Genre.EDUCATIONAL, 10);
    }
}

