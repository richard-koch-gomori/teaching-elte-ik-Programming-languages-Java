

package circle;

import circle.utils.Point;


public class Main
{
    public static void main(String[] args)
    {
        Circle c = new Circle(1, 2, 5);
        c.enlarge(10);
        System.out.println("area: " + c.getArea());
        System.out.println(c.toString());
    }
}
