// Széplaki Bence megoldása

public class MathUtils
{
    public static double power(int base, int exponent)
    {
        double res = 1;
        for(int i = 1; i <= Math.abs(exponent); i++)
        {
            res = res * base;
        }

        // ha itt megengedjük az egyenlőséget (programozási hiba) -> fail-el az eddig megírt unit test
        // helyesen exponent < 0
        if(exponent < 0)
        {
            if(base == 0) throw new IllegalArgumentException();
            res = 1 / res;
        }
        return res;
    }
}