package circle;

import circle.utils.Point;

import java.io.FileNotFoundException;
import java.io.IOException;


public class CircleMain
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        Point center = new Point(5, 2);

        Circle c1 = new Circle(center, 10);
        //System.out.println("c1 = " + c1.toString());
        System.out.println("c1 = " + c1);
        //System.out.println("area = " + c1.getArea());

        Circle c2 = new Circle(center, 20);
        System.out.println("c2 = " + c2);
        //System.out.println("area = " + c2.getArea());

        c1.getCenter().setX(0);
        c1.getCenter().setY(0);

        System.out.println("c1 = " + c1);

        //try
        //{
            Circle c3 = Circle.readFromFile("input_.txt");
            System.out.println("c3 = " + c3);
        //}
        /*catch (FileNotFoundException exc)
        {
            System.out.println("Unable to open file");
        }
        catch (IOException exc)
        {
            System.out.println("IO error occured");
        }

        c1.saveToFile("output.txt");*/
    }
}

