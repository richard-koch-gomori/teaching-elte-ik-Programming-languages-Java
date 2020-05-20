//Készítette: Lukács Dávid István
import java.util.HashSet;

public class CheckedSet<T>
{
    private HashSet<T> values;

    CheckedSet(){values=new HashSet<T>();}
    public int size()
    {
        return values.size();
    }
    public void add (T element) throws AlreadyContainedException
    {
        if(values.contains(element))
        {
            throw new AlreadyContainedException("Element is already in the CheckedSet");
        }
        values.add(element);
    }

    public boolean contains(T element)
    {
        return values.contains(element);
    }

    public String toString(){return values.toString();}
}