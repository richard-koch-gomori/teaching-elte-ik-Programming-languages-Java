



class Fel8
{
    // saját függvény definíciója
    public static int fact(int n)
    {
        int res = 1;
        for (int i = 1; i <= n; ++i)
        {
            res *= i; // res = res * i;
        }
        return res;
    }

    public static void main(String[] args)
    {
        System.out.println(fact(3));
        System.out.println(fact(5));
        System.out.println(fact(10));
    }
}

