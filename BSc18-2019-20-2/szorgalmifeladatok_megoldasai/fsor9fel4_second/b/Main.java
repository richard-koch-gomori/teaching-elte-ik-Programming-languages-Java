

import java.util.Arrays;
import java.util.LinkedList;


class Main
{
    public static void main(String[] args)
    {
        IntList list1 = new IntList();
        System.out.println("list1 = " + list1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        System.out.println("list1 = " + list1);

        IntList list2 = new IntList(new Integer[]{1, 3, 6, 8, 9, 11});
        System.out.println("list2 = " + list2);

        list1.concat(list2);
        System.out.println("list1 = " + list1);
        System.out.println("list2 = " + list2);
        list2.removeItemsGreaterThan(6);
        System.out.println("filtered list2: " + list2);
    }
}


