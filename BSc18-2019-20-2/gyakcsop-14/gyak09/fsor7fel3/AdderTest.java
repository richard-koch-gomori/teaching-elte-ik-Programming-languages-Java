

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdderTest
{
    @Test
    public void add_Add()
    {
        assertEquals(5, Integer.parseInt(Adder.add("2", "3")));
    }

    @Test
    public void add_Comm()
    {
        int res1 = Integer.parseInt(Adder.add("2", "7"));
        int res2 = Integer.parseInt(Adder.add("7", "2"));
        assertTrue(res1 == res2);
    }

    @Test
    public void add_Eps()
    {
        assertEquals(5.5, Double.parseDouble(Adder.add("2.1", "3.4")), 0.01);
    }

    // ez a TC fail-el
    @Test
    public void add_Binary()
    {
        assertEquals(23, Integer.parseInt(Adder.add("0b1010", "0b1101")));
    }
}

