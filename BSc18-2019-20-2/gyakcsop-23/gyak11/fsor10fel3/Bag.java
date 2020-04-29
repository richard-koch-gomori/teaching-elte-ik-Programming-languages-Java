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
        map.put(element, result); // a put() felülírja ha már van bent element kulcsú elem
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

    // hiányos megoldás, ld. következő gyakorlat
    public void remove(T element) throws NotInBagException
    {
        if (map.containsKey(element))
        {
            map.remove(element);
        }
        else
        {
            throw new NotInBagException("Element " + element + " not present in bag");
        }
    }
}

