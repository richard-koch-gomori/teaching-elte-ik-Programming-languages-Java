import java.util.ArrayList;
import java.util.Collections;

// Integer != int
// pl. Integer i = 7;
// Java: autoboxing és -unboxing
// https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html
// automatikus típuskonverzió primitív típus és a hozzá tartozó csomagoló osztály között

public class Main
{
    public static void minToFront(ArrayList<Integer> nums)
    {
        Integer min = Collections.min(nums);
        nums.remove(min);
        nums.add(0, min);
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(4);
        a1.add(65);
        a1.add(45);
        a1.add(44);
        a1.add(76);
        a1.add(2);
        a1.add(98);
        a1.add(72);
        minToFront(a1);
        System.out.println(a1);
    }
}

