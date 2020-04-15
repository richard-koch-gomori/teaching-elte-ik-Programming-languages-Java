

import java.util.LinkedList;

// LinkedList<TÍPUS>
// TÍPUS: generikus paraméter ami csak nem primitív típusú adat lehet

class Main
{
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
        //LinkedList<String> list = new LinkedList<String>();
        //list.add("ffff");
        //list.add("test1");
        //System.out.println(list);

        LinkedList<Integer> tmp = divisors(10);
        System.out.println(tmp);
        System.out.println(divisors(1));
        System.out.println(divisors(2));
        System.out.println(divisors(7));
        System.out.println(divisors(120));
    }
}

