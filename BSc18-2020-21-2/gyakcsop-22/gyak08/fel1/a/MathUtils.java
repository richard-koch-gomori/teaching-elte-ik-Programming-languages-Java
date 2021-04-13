// Széplaki Bence megoldása

public class MathUtils
{
    public static int power(int base, int exponent)
    {
        int res = 1;
        for(int i = 1; i <= exponent; i++)
        {
            res = res * base;
        }
        return res;
    }
}