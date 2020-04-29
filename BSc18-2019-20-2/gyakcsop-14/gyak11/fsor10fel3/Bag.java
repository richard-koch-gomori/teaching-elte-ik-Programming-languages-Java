import java.util.HashMap;

// kivételek 2 típus:
// - ellenőrzött
// - nem ellenőrzött: RuntimeException / Error -ból származik

// a kivételek közönséges osztályok, amelyek az Exception-ból származnak
class NotInBagException extends Exception
{
    public NotInBagException(String msg)
    {
        super(msg);
    }
}

class Bag<T> // generikus típusparaméter T
{
    private HashMap<T, Integer> map;

    public Bag()
    {
        map = new HashMap<T, Integer>();
    }

    public void add(T element)
    {
        int result;
        if (map.containsKey(element))
        {
            result = map.get(element) + 1;
        }
        else
        {
            result = 1;
        }
        map.put(element, result); // a put() felülírja ha már van bent element kulcsú elem
    }

    /*
    public int countOf(T element)
    {
        if (map.containsKey(element))
        {
            return map.get(element);
        }
        else
        {
            return 0;
        }
    }
    */

    public int countOf(T element)
    {
        Integer result = map.get(element);
        if (result == null) // ha a get() visszatérési értéke null, nincs element kulcsú pár a HashMap-ben
        {
            return 0;
        }
        else
        {
            return map.get(element);
        }
    }

    public void remove(T element) throws NotInBagException
    {
        Integer tmp = map.get(element);
        if (tmp == null)
        {
            throw new NotInBagException("Element " + element + " not present in bag");
        }
        if (tmp == 1)
        {
            map.remove(element);
        }
        else
        {
            map.put(element, tmp - 1);
        }
    }

    @Override
    public String toString()
    {
        return map.toString();
    }
}