

package circle;

import java.io.FileNotFoundException;
import java.io.IOException;

import circle.utils.Point;


public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Circle c = Circle.readFromFile("in.txt");
            System.out.println(c);
            c.setRadius(200);
            c.saveToFile("out.txt");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Unable to acces file, " + e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("IO error");
        }
    }
}

