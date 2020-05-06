/*
egy osztály megvalósíthatja a Comparable<T> interface-t,
ehhez meg kell valüsítania a compareTo(T that) metódust, itt implementáljuk, hogyan kell a this-t a that-tal összehasonlítani

compareTo() visszatérési értéke:
this > that             pozitív
this == that            0
this < that             negatív
*/


import java.util.ArrayList;
import java.util.Collections;


class Vector implements Comparable<Vector>
{
    private int x, y;

    public Vector(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return "(" + x + "," + y + ")";
    }

    // ez teljes rendezés
    /*
    @Override
    public int compareTo(Vector that)
    {
        if (this.x < that.x)
        {
            return -1;
        }
        else if (this.x == that.x)
        {
            if (this.y < that.y)
            {
                return -1;
            }
            else if (this.y == that.y)
            {
                return 0;
            }
            else
            {
                return 1;
            }
            // Integer.compareTo(this.y, that.y); éppen ugyanazt csinálja, mint amit itt if-elseif-else -el leírtam
        }
        else
        {
            return 1;
        }
    }
    */

    @Override
    public int compareTo(Vector that)
    {
        int xCompareResult = Integer.compare(this.x, that.x);

        if (xCompareResult == 0)
        {
            return Integer.compare(this.y, that.y);
        }

        return xCompareResult;
    }

    // ez nem rendezés
    /*
    @Override
    public int compareTo(Vector that)
    {
        if (this.x + that.x < this.y + that.y)
            return -1;
        else if (this.x + that.x == this.y + that.y)
            return 0;
        else return 1;
    }
    */

    /*
    // ez részbenrendezés nem de teljes rendezés
    @Override
    public int compareTo(Vector that)
    {
        if (this.x < that.x && this.y < that.y)
            return -1;
        else if (this.x == that.x && this.y == that.y)
            return 0;
        else if (this.x > that.x && this.y > that.y)
            return 1;
        else
        {
            // ilyenkor a két elem nem hasonlítható össze, bármit return-olhattam volna (vmit mindenképpen kell visszaadnia a függvénynek)
            return 1;

            // egyéb opció: kivétel, ha ezt megengedhető
            //throw new IllegalArgumentException();
        }
    }
    // a példa eredménye: [(2,3), (5,5), (5,3), (4,8), (6,2)]
    // pl (2,3), (4,8) jó sorrendben van, de a matematikai részbenrendezéssel pl a (6,2) és (4,8) nem hasonlítható össze
    */
}

class Main
{
    public static void main(String[] args)
    {
        /*
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(12);
        list.add(5);
        list.add(-2);
        list.add(1);
        */

        ArrayList<Vector> list = new ArrayList<Vector>();
        list.add(new Vector(2, 3));
        list.add(new Vector(5, 5));
        list.add(new Vector(5, 3));
        list.add(new Vector(4, 8));
        list.add(new Vector(6, 2));

        System.out.println(list);
        // sort() és min() etc. olyan argumentumot fogad, ami implementálja a compareTo() metódust
        Collections.sort(list);
        System.out.println(list);
        System.out.println(Collections.min(list));
    }
}