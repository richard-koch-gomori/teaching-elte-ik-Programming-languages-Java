

package circle;

import circle.utils.Point;


public class Main
{
    public static void main(String[] args)
    {
        Point p = new Point(1, 2);
        System.out.println(p);

        Point p2 = new Point();
        System.out.println(p2);
        p2.setX(7);
        //p2.x = 7;
        System.out.println(p2);

        Point center = new Point(1, 3);
        Circle c = new Circle(center, 5, "label1");
        System.out.println(c);
        center.setX(17);
        System.out.println(c); // ha a Circle konstruktora nem készítene saját Point másolatot, itt (17, 3) íródna ki

        Circle c2 = new Circle(new Point(2, 3), 10, null);
        System.out.println(c2);
    }
}

/*
stack                   heap

center -------------- Point(17, 3)

// Circle() lemásolja Point-t, a heap-en keletkezik egy másolat
c.center ------------ Point(1, 3)
*/