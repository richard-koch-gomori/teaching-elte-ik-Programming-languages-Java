
import java.util.LinkedList;

/*
csomagoló osztály:
pl. int - Integer

class Integer
{
    int data;

    // ...
}
*/

public class Main
{
    // generikus típus: csak nem primitív típus lehet
    public static LinkedList<Integer> divisors(int num)
    {
        LinkedList<Integer> result = new LinkedList<Integer>();
        for (int i = 1; i <= num; ++i)
        {
            if (num % i == 0)
            {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(divisors(10));
        System.out.println(divisors(2));
        System.out.println(divisors(90));
    }
}

