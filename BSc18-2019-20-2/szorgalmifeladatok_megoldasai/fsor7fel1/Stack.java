import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack
{
    private ArrayList<Integer> x = new ArrayList<>();

    public Stack(){}
    
    public void push(int that)
    {
        x.add(that);
    }

    public int pop()
    {
        if(x.size() > 0)
        {
            int res = x.get(x.size()-1);
            x.remove(x.size()-1);
            return res;
        }
        else
        {
            throw  new NoSuchElementException("Üres verem!");
        }
    }

    public boolean empty()
    {
        return (x.size() == 0);
    }

    public int size()
    {
        return x.size();
    }
}