import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BarTest{

    //Beverage osztály tesztelése:
    @Test(expected = IllegalArgumentException.class)
    public void BeverageException1(){
        String name=null;
        Beverage bev1 = new Beverage(name, 18);            //nullstring átadása paraméterként
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void BeverageException2(){
        Beverage bev1 = new Beverage("", 18);            //nulla hosszúságú string paraméter
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void BeverageException3(){
        Beverage bev1 = new Beverage("Beer", -5);        //negatív életkor paraméter
    }
    
    @Test
    public void BeverageWorks(){
        Beverage bev1 = new Beverage("Beer", 18);            //Ital létrehozása legális paraméterekkel
        
        assertEquals(true, bev1.getName().equals("Beer"));    //Itt igazából a gettereket is leteszteljük.
        assertEquals(18, bev1.getLegalAge());
    }
    
    //Guest osztály tesztelése:
    @Test
    public void GuestGetters(){
        Guest guest = new Guest("Steve", 18);
        
        assertEquals("Steve", guest.getName());
        assertEquals(18, guest.getAge());
    }
    
    //Bartender osztály tesztelése:
    @Test
    public void OrderCases(){
        Bartender bartender = new Bartender();
        Beverage beer = new Beverage("Beer", 18);
        Beverage juice = new Beverage("Juice", 0);
        Minor minor = new Minor("Joey", 14);
        Adult adult = new Adult("Steve", 22);
        
        assertFalse(bartender.order(beer, minor));        //Rendelések lehetséges végkimenetelei
        assertTrue(bartender.order(beer, adult));
        assertTrue(bartender.order(juice, minor));
    }
}