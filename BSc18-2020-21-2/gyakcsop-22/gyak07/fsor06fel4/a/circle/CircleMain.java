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
        // a felhasználó kódnak a readFromFile() és saveToFile esetében figyelnie kell, hogy milyen
        // kivétel léphet fel, és ezekre az eshetőségekre fel kell készülnie
        try{
            c2 = Circle.readFromFile("circle/in.txt");
            c.saveToFile("circle/out.txt");
        }
        catch(FileNotFoundException e){
            System.out.println("FileNotFoundException");
            System.exit(1);
        }
        catch(IOException e){
            System.out.println("IOException");
            System.exit(1);
        }

        //Circle c2 = Circle.readFromFile("in.txt");
        System.out.println(c2);
    }
}


