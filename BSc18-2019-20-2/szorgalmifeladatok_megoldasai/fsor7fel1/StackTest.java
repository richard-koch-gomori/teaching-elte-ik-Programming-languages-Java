import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class StackTest {


    //javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar StackTest.java
    //java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore StackTest
    @Test
    public void testFirst()
    {
        Stack res = new Stack();
        res.push(1);
        res.push(2);
        assertEquals(2, res.pop());
    }

    @Test
    public void testNewIsEmpty()
    {
        Stack res = new Stack();
        assertEquals(0, res.size());
    }

    @Test
    public void testIsEmptyTheNonEmpty()
    {
        Stack res = new Stack();
        res.push(12);
        assertTrue(res.size() > 0);
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyPop()
    {
        Stack res = new Stack();
        res.pop();
    }

    @Test
    public void testSize()
    {
        Stack res = new Stack();
        res.push(12);
        assertTrue(res.size() == 1);
        res.pop();
        assertTrue(res.size() == 0);
    }

    @Test
    public void testPopAndPush()
    {
        Stack res = new Stack();
        res.push(1);
        res.push(2);
        res.push(3);
        assertTrue(res.pop() == 3);
        assertTrue(res.pop() == 2);
        res.push(99);
        assertTrue(res.pop() == 99);
        assertTrue(res.pop() == 1);
        assertTrue(res.size() == 0);
    }

    @Test
    public void testEmptyAfterLastPop()
    {
        Stack res = new Stack();
        res.push(1);
        res.push(2);
        res.push(3);
        res.pop();
        res.pop();
        assertTrue(res.size() == 1);
        res.pop();
        assertTrue(res.size() == 0);
    }
}