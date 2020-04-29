import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class VectorTest
{
    @Test
    public void equals_IsReflexiv()
    {
        Vector v = new Vector(2, 3);
        assertTrue(v.equals(v));
    }

    @Test
    public void equals_IsSymm1() // aRb => bRa
    {
        Vector a = new Vector(2, 4);
        Vector b = new Vector(2, 4);
        if (a.equals(b))
        {
            assertTrue(b.equals(a));
        }
    }

    @Test
    public void equals_IsSymm2() // aRb => bRa
    {
        Vector a = new Vector(2, 4);
        Vector b = new Vector(2, 7);
        if (a.equals(b))
        {
            assertTrue(b.equals(a));
        }
    }

    /*
    @Test
    public void equals_IsTransitive()
    {
        
    }
    */

    @Test(expected = NullPointerException.class)
    public void equals_NullRef()
    {
        Vector v = null;
        v.equals(null);
    }

    @Test
    public void equalObjHashCodeIsSame()
    {
        Vector v1 = new Vector(1, 3);
        Vector v2 = new Vector(1, 3);
        assertTrue(v1.equals(v2));
        assertTrue(v1.hashCode() == v2.hashCode());
    }
}