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

        double sum_x = 0;
        double sum_y = 0;
        for (int i = 0; i < 3; ++i)
        {
            sum_x += array[i].getX();
            sum_y += array[i].getY();
        }
        Point center = new Point(sum_x / 3, sum_y / 3);

        System.out.println("Tomegkozeppont = " + center);
    }
}


