// Széplaki Bence megoldása

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class MathUtilsTest
{
    @Test
    public void postopos()
    {
        assertEquals(8 , MathUtils.power(2, 3), 0.001);
    }

    @Test
    public void postozero()
    {
        assertEquals(1, MathUtils.power(1, 0), 0.001);
    }

    @Test
    public void zerotopos()
    {
        assertEquals(0 , MathUtils.power(0, 3), 0.001);
    }

    @Test
    public void onetopos()
    {
        assertEquals(1, MathUtils.power(1, 5), 0.001);
    }

    @Test
    public void zerotozero()
    {
        assertEquals(1 , MathUtils.power(0, 0), 0.001);
    }
}