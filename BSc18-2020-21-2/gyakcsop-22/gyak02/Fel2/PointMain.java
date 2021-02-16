
/*
primitív típus:
- 8 típus: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

nem primitív típus:
- MINDEN más
- pl. String
- heap-en tárolódnak, ált. new-val hozzuk létre
*/



// osztálydefiníció
// Point: x és y adataggjai
class Point
{
    int x;
    int y;

    // metódus
    // a pont koordinátáit eltolja dx-el ill. dy-al
    void move(int dx, int dy)
    {
        x += dx;
        y += dy;
    }

    void mirror(Point center)
    {
        x = 2*center.x - x;
        y = 2*center.y - y;
    }

    double distance(Point p)
    {
        //return Math.sqrt((x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }
};

class PointMain
{
    public static void main(String[] args)
    {
        // p1: referencia
        Point p1;

        // Point példányosítása
        p1 = new Point(); // new -- C: malloc()
        // p1 mutat a heap-en a Point objektumra
        //egy sorban: Point p1 = new Point();

        p1.x = 5;
        p1.y = -1;

        System.out.println("p1: x = " + p1.x + ", y = " + p1.y);

        Point p2 = new Point();
        p2.x = 10;
        p2.y = 20;
        System.out.println("p2: x = " + p2.x + ", y = " + p2.y);

        System.out.println("distance between p1 and p2 = " + p1.distance(p2));
        /*
        Point center = new Point();
        center.x = center.y = 1;
        p1.mirror(center);
        System.out.println("p1 after mirror: x = " + p1.x + ", y = " + p1.y);

        p1.move(1, 2);
        System.out.println("p1 after move: x = " + p1.x + ", y = " + p1.y);
        */
    }
}

