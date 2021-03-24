package circle;

import java.io.*;

import circle.utils.Point;


public class CircleMain
{
    public static void main(String[] args)
    {
        Circle c = new Circle(5, 2, 10);
        System.out.println("area = " + c.getArea());
        Point center = c.getCenter();
        System.out.println("center: x = " + center.getX() + ", y = " + center.getY());
        
        Circle c2 = null;
        c2 = Circle.readFromFile("circle/in.txt");
        System.out.println(c2);

        Circle c3 = null;
        c3 = Circle.readFromFile("circle/nonexists.txt");
        System.out.println(c3);

        try{
            c.saveToFile("circle/out.txt");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
            System.exit(1);
        }
    }
}


