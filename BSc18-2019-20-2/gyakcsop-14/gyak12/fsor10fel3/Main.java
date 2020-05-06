
import java.util.*;
import java.io.*;


class Main
{
    public static void main(String[] args)
    {
        /*
        Bag<String> bag1 = new Bag<String>();
        bag1.add("alma");
        bag1.add("alma");
        bag1.add("korte");
        System.out.println(bag1);
        System.out.println(bag1.countOf("dmat"));
        System.out.println(bag1.countOf("alma"));
        try
        {
            bag1.remove("almaa");
        }
        catch (NotInBagException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(bag1);
        */

        Bag<String> bag = new Bag<String>();

        File input = new File(args[0]);
        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(input));

            String line;
            while ((line = bf.readLine()) != null)
            {
                //System.out.println(line);
                bag.add(line);
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(bag);
    }
}
