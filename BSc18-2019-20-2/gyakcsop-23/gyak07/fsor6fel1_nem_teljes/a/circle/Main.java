

package circle;

import circle.utils.Point;


public class Main
{
    public static void main(String[] args)
    {
        /*
        Circle c1 = new Circle(3, 5, 10);
        System.out.println(c1.toString());
        c1.enlarge(3);
        System.out.println(c1);
        */

        Point p = new Point();
        System.out.println(p);
        Circle c = new Circle(p, 10, "c1");
        System.out.println(c);
        p.setX(5);
        System.out.println(c); // ha a Circle konstruktora nem készítene saját Point másolatot, itt (5, 0) íródna ki

        Circle c2 = new Circle(p, 10, null);
        System.out.println(c2);
    }
}

/*
heap            stack
p ----------- Point(5, 0)

// Circle() lemásolja a Point-t, a heap-en keletkezik egy másolat
c.center ---- Point(0, 0)


*/