
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import java.util.NoSuchElementException;

public class StackTest
{
    // teszt 1
    @Test
    public void test_elem1()
    {
        Stack verem = Stack.make(2);
        verem.push(4);
        verem.push(2);

        assertEquals(2, verem.pop());
        assertEquals(4, verem.pop());
    }
	
    // teszt 2
    @Test
    public void test_uresTrue()
    {
        Stack verem = Stack.make(2);
    
		assertEquals(true, verem.isEmpty());
	}
    // teszt 3
    @Test
    public void test_uresFalse()
    {
        Stack verem = Stack.make(2);
        verem.push(2);
    
		assertEquals(false, verem.isEmpty());
	}
	
    // teszt 4
    @Test(expected = NoSuchElementException.class)
    public void test_hibatDob()
    {
        Stack verem = Stack.make(2);
		
		verem.pop();
    }
	
    // teszt 5
    @Test
    public void test_sizeTeszt()
    {
        Stack verem = Stack.make(2);
		
        verem.push(2);
		assertEquals(1, verem.size());
		
        verem.pop();
		assertEquals(0, verem.size());
	}
	
    // teszt 6
    @Test
    public void test_uresKikeruleskor()
    {
        Stack verem = Stack.make(2);
		
        verem.push(2);
        verem.push(3);
		
        verem.pop();
        verem.pop();
        
		assertEquals(true, verem.isEmpty());
	}
}
