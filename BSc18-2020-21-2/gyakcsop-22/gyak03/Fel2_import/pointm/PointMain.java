package pointm;


// a Point osztály elérése (a point2d csomagból)
// teljesen minősített név (fully qualified name): csomagnév.osztálynév

// ha nem akarjuk mindig kiírni, import-olhatjuk:
import point2d.Point;


class PointMain
{
    public static void main(String[] args)
    {
        Point p1;

        p1 = new Point();

        p1.x = 5;
        p1.y = -1;

        System.out.println("p1: x = " + p1.x + ", y = " + p1.y);

        Point p2 = new Point();
        p2.x = 10;
        p2.y = 20;
        System.out.println("p2: x = " + p2.x + ", y = " + p2.y);

        System.out.println("distance between p1 and p2 = " + p1.distance(p2));
    }
}

