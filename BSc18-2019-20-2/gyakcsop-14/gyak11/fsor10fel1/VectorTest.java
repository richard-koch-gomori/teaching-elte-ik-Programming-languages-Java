import static org.junit.Assert.*;
import org.junit.Test;

public class VectorTest
{
    @Test
    public void equals_Reflexiv()
    {
        Vector v = new Vector(2, 3);
        assertTrue(v.equals(v));
    }

    @Test
    public void equals_Symm1() // aRb => bRa
    {
        Vector a = new Vector(2, 3);
        Vector b = new Vector(2, 3);
        if (a.equals(b))
        {
            assertTrue(b.equals(a));
        }
    }

    @Test
    public void equals_Symm2() // aRb => bRa
    {
        Vector a = new Vector(2, 3);
        Vector b = new Vector(2, 4);
        if (a.equals(b))
        {
            assertTrue(b.equals(a));
        }
    }

    /*
    @Test
    public is_Trans()
    {

    }
    */

    @Test(expected = NullPointerException.class)
    public void equals_NullRef()
    {
        Vector a = null;
        a.equals(null);
    }

    @Test
    public void sameHashCodeOnEqual()
    {
        Vector v1 = new Vector(2, 3);
        Vector v2 = new Vector(2, 3);
        assertTrue(v1.equals(v2));
        assertTrue(v1.hashCode() == v2.hashCode());
    }
}