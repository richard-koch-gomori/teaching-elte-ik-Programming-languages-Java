
import java.util.LinkedList;

// https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html

class Main
{
    // generikus paraméter: nem primitív típus lehet
    public static LinkedList<Integer> divisors(int num)
    {
        //LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<Integer>();
        for (int i = 1; i <= Math.sqrt(num); ++i)
        {
            if (num % i == 0)
            {
                result.add(i);
                if (num / i != i)
                {
                    result.add(num / i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        LinkedList<Integer> res = divisors(10);
        System.out.println(res);

        System.out.println(divisors(30));
        System.out.println(divisors(1));
        System.out.println(divisors(2));
        System.out.println(divisors(7));
        System.out.println(divisors(120));
    }
}

