package circle;

import circle.utils.Point;


public class Main
{
    public static void main(String[] args)
    {
        Point[] array = new Point[3];

        for (int i = 0; i < 3; ++i)
        {
            System.out.print("x=");
            double x = Double.parseDouble(System.console().readLine());
            System.out.print("y=");
            double y = Double.parseDouble(System.console().readLine());
            array[i] = new Point(x, y);
        }

        //System.out.println(array[1].distance(array[0]));

        Point.getCenter(array); // statikus metódus hívása
        System.out.println("Tomegkozeppont = " + center);
    }
}


