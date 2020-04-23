//készítette:Lukács Dávid István
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.beans.Transient;
import org.junit.Test;


public class ColoursTest {
    @Test
    public void testColouredPoint()
    {
        Colour c = Colour.RED;
        ColouredPoint Testing = new ColouredPoint(c,5.0,6.0);
        assertTrue(Testing.getColour()==Colour.RED);
        assertTrue(Testing.getX()==5.0 && Testing.getY()==6);
    }

    @Test
    public void testColouredCircle()
    {
        Colour c2 = Colour.GREEN;
        ColouredPoint Testing2= new ColouredPoint(c2,3.0,4.0);
        ColouredCircle TestCircle=new ColouredCircle(Testing2,5,"test");
        assertTrue(TestCircle.getCenter().getColour()==Colour.GREEN);
        assertTrue(TestCircle.getCenter().getX()==3.0 && TestCircle.getCenter().getY()==4.0);
        assertTrue(TestCircle.getcColour()==TestCircle.getCenter().getColour());
    }
}