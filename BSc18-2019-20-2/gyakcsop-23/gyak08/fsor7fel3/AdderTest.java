

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class AdderTest
{
    public static final double EPSILON = 0.01;

    @Test
    public void add_General()
    {
        int result1 = Integer.parseInt(Adder.add("1", "2"));
        assertEquals(3, result1);
    }

    @Test
    public void add_Comm()
    {
        int result1 = Integer.parseInt(Adder.add("1", "2"));
        int result2 = Integer.parseInt(Adder.add("2", "1"));
        assertTrue(result1 == result2);
    }

    @Test
    public void add_eps()
    {
        double result1 = Double.parseDouble(Adder.add("1.1", "2.4"));
        assertEquals(3.5, result1, EPSILON); // EPSILON hibakorláttal egyenlő
    }

    // ez a unit test fail-el, tehát az Adder kód pl a bináris összeadásra vonatkozó elvárásokat nem teljesíti
    @Test
    public void add_binary()
    {
        int result1 = Integer.parseInt(Adder.add("0b1100", "0b10101"));
        assertEquals(33, result1);
    }
}

