

import java.util.Arrays;
import java.util.LinkedList;


class Main
{
    public static void main(String[] args)
    {
        NamedIntList list1 = new NamedIntList("namedlist1");
        System.out.println(list1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        System.out.println(list1);

        NamedIntList list2 = new NamedIntList("namedlist2", new Integer[]{1, 3, 6, 8, 9, 11});
        System.out.println(list2);

        list1.concat(list2);
        System.out.println(list1);
        System.out.println(list2);

        list2.removeItemsGreaterThan(6);
        System.out.println("filtered: " + list2);
    }
}


