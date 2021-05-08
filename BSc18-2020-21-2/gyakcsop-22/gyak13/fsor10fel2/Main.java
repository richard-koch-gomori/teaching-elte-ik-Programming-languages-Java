// Jónás Bendegúz Gergő megoldása

import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

/*public class Main
{
    public static void main(String[] args)
    {
        Bag<String> bag = new Bag<>();

        bag.add("foo");
        bag.add("foo");
        bag.add("foo");
        bag.add("foo2");
        bag.add("foo3");
        bag.add("idk");
        bag.add("idk");

        System.out.println(bag);

        try
        {
            bag.remove("foo");
            bag.remove("asd");
        }
        catch(NotInBagException e)
        {
            System.out.println(e);
        }

        System.out.println(bag);
    }
}*/

public class Main
{
    public static void main(String[] args)
    {
        File inf = new File("input.txt");

        Bag<String> bag = new Bag<>();

        try(Scanner sc = new Scanner(inf))
        {
            while(sc.hasNextLine())
            {
                bag.add(sc.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Nem létezik a fájl!");
        }

        System.out.println(bag);
    }
}

class Bag<T>
{
    private HashMap<T, Integer> m;

    public Bag()
    {
        m = new HashMap<T, Integer>();
    }

    public void add(T element)
    {
        Integer current = m.get(element);
        if(current != null)
        {
            m.replace(element, current+1);
        }
        else m.put(element, 1);
    }

    public int countOf(T element)
    {
        Integer current = m.get(element);

        if(current != null) 
        {
            return current;
        }
        else 
        {
            return 0;
        }
    }

    public String toString() 
    {
       return m.toString();
    }

    public void remove(T element) throws NotInBagException
    {
        Integer current = m.get(element);

        if(current != null) 
        {
            if(current == 1)
            {
                m.remove(element);
            }
            else
            {
                m.replace(element, current - 1);
            }  
        }
        else 
        {
            throw new NotInBagException("Az elem: " + element + " nincs a zsákban!");
        }
    }
}

/*
a kivételek közönséges osztályok, amelyek az Exception-ból származnak
kivételek 2 típusa:
    Ellenőrzött kivétel - Exception-ből származik (de nem a RuntimeException-ből)
    Nem ellenőrzött kivétel - RuntimeException-ből vagy Error-ból származik
*/
class NotInBagException extends Exception
{
    public NotInBagException(String message)
    {
        super(message);
    }
}


