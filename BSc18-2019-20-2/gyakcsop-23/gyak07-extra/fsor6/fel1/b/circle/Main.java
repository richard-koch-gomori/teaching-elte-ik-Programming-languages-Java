

package circle;

import java.io.FileNotFoundException;
import java.io.IOException;

import circle.utils.Point;


public class Main
{
    public static void main(String[] args)
    {
        Circle c = Circle.readFromFile("in.txt");
        System.out.println(c);
    }
}


/*
Azt figyelhetjük meg, hogy a Circle osztály (a) és (b) megoldása két különböző módot
választ a kivételek kezelésére: (a) engedi a kivételeket a hívóhoz kerülni (b) megoldja
saját hatáskörében

-> előnyök és hátrányok; vannak nézőpontok, akik azt gondolják, hogy nem jó API határokon
kivételeket átengedi
*/

