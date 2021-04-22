

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class BookTest
{
    // minden @Test metódus előtt lefut
    @Before
    public void Book_init()
    {
        Book.resetId();
    }

    // minden @Test metódus után lefut
    @After
    public void Book_finalize()
    {
        Book.resetId();
    }

    // invalid argumentumok esetén null-t kapunk
    @Test
    public void make_InvalidArgs()
    {
        assertEquals(null, Book.make(null, "", "", ""));
        assertEquals(null, Book.make("1", "32443t43", "46   346 32", "2 36236   26"));
        assertEquals(null, Book.make("author", "ewtw4t42@@đ^", "SCIFI", "10000"));
        assertEquals(null, Book.make("author", "title", "SCIFI", "-1"));
    }

    @Test
    public void make_Price()
    {
        Book b1 = Book.make("author", "title", "SCIFI", "10000");
        Book b2 = Book.make("author2", "title", "SCIFI", "9999");

        assertEquals(10000, b1.getReservePrice());
        assertEquals(9999, b2.getReservePrice());
    }

    @Test
    public void make_Id()
    {
        Book b1 = Book.make("author", "title", "SCIFI", "10000");
        Book b2 = Book.make("author2", "title", "SCIFI", "9999");

        assertEquals(0, b1.getId());
        assertEquals(1, b2.getId());
    }

    @Test
    public void compare_LessOrGreater()
    {
        Book b1 = Book.make("author", "title", "SCIFI", "10000");
        Book b2 = Book.make("author2", "title", "SCIFI", "9999");

        assertEquals(1, b1.compare(b2));
        assertEquals(-1, b2.compare(b1));
    }

    @Test
    public void compare_Equality()
    {
        Book b1 = Book.make("author", "title", "SCIFI", "10000");
        Book b2 = Book.make("author2", "title", "SCIFI", "10000");

        assertEquals(0, b1.compare(b2));
    }

    // azt várjuk, hogy a függvény IllegalArgumentException kivételt dobjon
    @Test(expected = IllegalArgumentException.class)
    public void compare_Exc()
    {
        Book b1 = Book.make("author", "title", "EDUCATIONAL", "10000");
        Book b2 = Book.make("author2", "title", "SCIFI", "10000");

        b1.compare(b2);
    }
}

