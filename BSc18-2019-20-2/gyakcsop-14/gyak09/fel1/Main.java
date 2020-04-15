

import java.util.LinkedList;


/*
hagyományos tömbök:
inicializáláskor megadott méretnél nem lehet több elemük

LinkedList<TÍPUS>
TÍPUS-ú elemek láncolt listája

LinkedList<String> object = new LinkedList<String>();
object.add("A");
object.add("B");
object.add(2, "E");
object.add("F");
object.add("G");
System.out.println("Linked list : " + object);

TÍPUS: generikus paraméter: csak nem primitív típus lehet

ha pl int v double kell, akkor a nekik megfelelő csomagoló osztályt kell használni: Integer v Double

Primitive type	Wrapper class
boolean	Boolean
byte	Byte
char	Character
float	Float
int	Integer
long	Long
short	Short
double	Double

Integer x = 12;

autoboxing: a primitív típusok és a neki megfelelő csomagoló osztály közötti automatikus típuskonverzió
https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html
*/

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

