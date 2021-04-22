// Horváth András megoldása

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class Main {
    /*public static void main(String[] args) {
        Book b1= Book.Make("Geri","Java",10,"FANTASY");
    }*/

    @Test
    public void makenull()
    {
        assertEquals(null, Book.Make(null,"bvruh",10,"izé"));
        assertEquals(null,Book.Make("b","",10,""));
        assertEquals(null,Book.Make("brug","bruv",-1,"bruh"));
        assertEquals(null,Book.Make("brug","bruv",10,"bruh"));
    }

    @Test
    public void correctid()
    {
        Book b1=Book.Make("Gergely", "Eszik", 10, "EDUCATIONAL");
        Book b2=Book.Make("Gergely2", "MegintEszik", 10, "EDUCATIONAL");
        assertEquals(0,b1.get_id());
        assertEquals(1,b2.get_id());
    }
}
