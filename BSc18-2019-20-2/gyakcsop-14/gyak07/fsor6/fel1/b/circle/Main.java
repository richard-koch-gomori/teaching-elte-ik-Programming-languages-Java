

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

