

class Point
{
    int x;
    int y;

    void move(int dx, int dy)
    {
        x = x + dx;
        //x += dx;
        y = y + dy;
    }

    void mirror(Point c)
    {
        x = 2*c.x - x;
        y = 2*c.y - y;
    }

    double distance(Point p)
    {
        return Math.sqrt( Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2) );
    }
}

class PointMain
{
    public static void main(String[] args)
    {
        Point p;
        p = new Point();
        p.x = 5;
        p.y = 10;
        p.move(2, 3);
        System.out.println("p.x = " + p.x + ", p.y = " + p.y);

        Point p2 = new Point();
        p2.x = 2;
        p2.y = -1;
        p2.move(-1, -1);
        System.out.println("p2.x = " + p2.x + ", p2.y = " + p2.y);

        System.out.println("-------------------");
        System.out.println("p.x = " + p.x + ", p.y = " + p.y);
        Point origo = new Point();
        origo.x = origo.y = 0;
        p.mirror(origo);
        System.out.println("p.x = " + p.x + ", p.y = " + p.y);
        //System.out.println("distance = " + p.distance(origo));
        System.out.printf("distance = %.2f", p.distance(origo));
    }
}



