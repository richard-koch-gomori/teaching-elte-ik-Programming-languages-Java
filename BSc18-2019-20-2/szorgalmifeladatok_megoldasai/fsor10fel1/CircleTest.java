//Készítette: Lukács Dávid István
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class CircleTest
{
    @Test
    public void isReflexive()
    {
        Circle test1= new Circle(5.3,4.5,20.6);
        assertTrue(test1.equals(test1) && test1.hashCode()==test1.hashCode());
    }

    @Test
    public void isTransitive()
    {
        Circle test1= new Circle(5,4,20);
        Circle test2= new Circle(6,3,20);
        Circle test3= new Circle(2,6,20);
        assertTrue(test1.equals(test2));
        assertTrue(test1.hashCode()==test2.hashCode());
        assertTrue(test2.hashCode()==test3.hashCode());
        assertTrue(test1.hashCode()==test3.hashCode());
    }

    @Test
    public void isSymmetrical()
    {
        Circle test1= new Circle(5,4,20);
        Circle test2= new Circle(6,3,20);
        assertTrue(test1.equals(test2));
        assertTrue(test1.hashCode()==test2.hashCode());
        assertTrue(test2.hashCode()==test1.hashCode());
    }

    @Test
    public void nullPtr()
    {
        Circle test1= new Circle(5,4,20);
        Circle test2=null;
        assertTrue(test1!=null);
        assertTrue(test1.equals(null)==false);
    }

    @Test(expected= NullPointerException.class)
    public void nullPtrThrows()
    {
        Circle test1= new Circle(5,4,20);
        Circle test2=null;
        assertTrue(!test2.equals(test1));
    }

    @Test
    public void notEqual()
    {
        Circle test1= new Circle(5,4,20.3);
        Circle test2= new Circle(6,3,20.7);
        assertTrue(!test1.equals(test2));
        assertTrue(test1.hashCode()!=test2.hashCode());
    }
}