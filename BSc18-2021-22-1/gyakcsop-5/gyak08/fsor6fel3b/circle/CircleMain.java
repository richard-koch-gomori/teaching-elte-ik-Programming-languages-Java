package circle;

import circle.utils.Point;


public class CircleMain
{
    public static void main(String[] args)
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

        Circle c3 = Circle.readFromFile("input.txt");
        System.out.println("c3 = " + c3);
    }
}


