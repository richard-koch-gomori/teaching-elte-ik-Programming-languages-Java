// Peszleg Márton megoldása
// félkész megoldás, ld. köv. gyak.

import java.util.HashMap;

public class Fsor10fel2
{
    public static void main(String[] args)
    {
        System.out.println("Hello, World!");
    }
}

class Bag<T> // generikus típusparaméter T
{
    private HashMap<T,Integer> m;

    public Bag()
    {
        m = new HashMap<T,Integer>();
    }

    public void add(T element)
    {
        Integer current = m.get(element);
        if(current != null)
        {
            m.replace(element, current+1);
        }
        else m.put(element, 1);
    }
}
