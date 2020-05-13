import java.util.HashSet;
import java.util.Iterator;

class Example
{
    public static void main(String[] args)
    {
        HashSet<Integer> set = new HashSet<Integer>();

        set.add(4);
        set.add(6);
        set.add(7);
        set.add(10);

        /*
        for (Integer item : set)
        {
            if (item % 2 == 1)
            {
                set.remove(item);
            }
        }
        */

        Iterator<Integer> it = set.iterator();
        while (it.hasNext())
        {
            //System.out.println(it.next());
            int item = it.next();
            if (item % 2 == 1)
            {
                it.remove();
            }
        }

        System.out.println(set);
    }
}

