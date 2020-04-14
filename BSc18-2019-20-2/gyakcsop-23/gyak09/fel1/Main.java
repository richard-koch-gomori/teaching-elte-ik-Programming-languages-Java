
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
        LinkedList<Integer> res = divisors(10);
        System.out.println(res);

        System.out.println(divisors(30));
        System.out.println(divisors(1));
        System.out.println(divisors(2));
        System.out.println(divisors(7));
        System.out.println(divisors(120));
    }
}

/*
miért LinkedList, és nem ArrayList?

https://stackoverflow.com/questions/322715/when-to-use-linkedlist-over-arraylist-in-java

megnézve a költségeket, általánosságban
- a LinkedList gyors elemek hozzáadásakor, de lassú konkrét indexű elem lekérdezésekor
- az ArrayList lassú elemek hozzádásakor, de gyors konkrét indexű elem lekérdezésekor

mit jelent h "O(1) amortized"?
- a műveletet sokszor végrehajtva, átlagosan O(1) költségű
- klasszikus példa az ArrayList add()-ja: inicializáláskor vmilyen méretű tömb jön létre;
  amikor egy add() híváskor ez betelik, új területet foglal, majd az összes korábbi
  elemet másolni kell (ami O(n) költségű)

ctrl c ctrl v stackoverflow:

Summary ArrayList with ArrayDeque are preferable in many more use-cases than LinkedList.
If you're not sure — just start with ArrayList.

LinkedList and ArrayList are two different implementations of the List interface.
LinkedList implements it with a doubly-linked list. ArrayList implements it with a
dynamically re-sizing array.

As with standard linked list and array operations, the various methods will have different
algorithmic runtimes.

For LinkedList<E>

get(int index) is O(n) (with n/4 steps on average)
add(E element) is O(1)
add(int index, E element) is O(n) (with n/4 steps on average),
but O(1) when index = 0 <--- main benefit of LinkedList<E>
remove(int index) is O(n) (with n/4 steps on average)
Iterator.remove() is O(1). <--- main benefit of LinkedList<E>
ListIterator.add(E element) is O(1) This is one of the main benefits of LinkedList<E>
Note: Many of the operations need n/4 steps on average, constant number of steps in the
best case (e.g. index = 0), and n/2 steps in worst case (middle of list)

For ArrayList<E>

get(int index) is O(1) <--- main benefit of ArrayList<E>
add(E element) is O(1) amortized, but O(n) worst-case since the array must be resized and copied
add(int index, E element) is O(n) (with n/2 steps on average)
remove(int index) is O(n) (with n/2 steps on average)
Iterator.remove() is O(n) (with n/2 steps on average)
ListIterator.add(E element) is O(n) (with n/2 steps on average)
*/


