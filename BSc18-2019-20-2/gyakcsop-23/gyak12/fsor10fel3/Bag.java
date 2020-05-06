import java.util.HashMap;

class NotInBagException extends Exception
{
    public NotInBagException(String msg)
    {
        super(msg);
    }
}

class Bag<T> 
{
    private HashMap<T, Integer> map;

    public Bag()
    {
        map = new HashMap<T, Integer>();
    }

    @Override
    public String toString()
    {
        return this.map.toString();
    }

    public void add(T element)
    {
        int result = 1;
        if (map.containsKey(element))
        {
            result = map.get(element) + 1;
        }
        map.put(element, result);
    }

    public int countOf(T element)
    {
        Integer current = map.get(element);
        if (current == null)
        {
            return 0;
        }
        else
        {
            return current;
        }
    }

    public void remove(T element) throws NotInBagException
    {
        if (map.containsKey(element))
        {
            int tmp = map.get(element);
            if (tmp == 1)
            {
                map.remove(element);
            }
            else
            {
                map.put(element, tmp - 1);
            }
        }
        else
        {
            throw new NotInBagException("Element " + element + " not present in bag");
        }
    }
}

