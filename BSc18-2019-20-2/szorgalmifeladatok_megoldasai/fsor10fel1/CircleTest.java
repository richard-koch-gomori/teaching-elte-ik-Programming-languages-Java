//Készítette: Korom Pál Gábor

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CircleTest{
    
    @Test(expected = NullPointerException.class)
    public void Circle_exception(){
        Circle c1 = null;
        Circle c2 = new Circle(8,10,10);
        
        c1.equals(c2);
    }
    
    @Test
    public void Circle_equals(){
        Circle c1 = new Circle(1,2,10);
        Circle c2 = new Circle(8,10,10);
        Circle c3 = new Circle(3,4,20);
        Circle c4 = null;
        Circle c5 = new Circle(5,6,10);
        
        assertFalse( c1.equals(c4) );
        assertTrue( c1.equals(c1) );
        assertTrue( c1.equals(c2) );
        assertTrue( c2.equals(c1) );        //Szimmetria: ha c1 = c2, akkor c2 = c1
        assertTrue( c2.equals(c5) );
        assertTrue( c1.equals(c5) );        //Tranzitivitás: ha c1 = c2 és c2 = c5, akkor c1 = c5
        assertFalse( c1.equals(c3) );
    }
    
    @Test
    public void Circle_hashCode(){
        Circle c1 = new Circle(4,5,10);
        Circle c2 = new Circle(8,10,10);
        Circle c3 = new Circle(4,5,20);
        
        assertEquals( c1.hashCode(), c2.hashCode() );
        assertFalse( c1.hashCode() == c3.hashCode() );
    }
}