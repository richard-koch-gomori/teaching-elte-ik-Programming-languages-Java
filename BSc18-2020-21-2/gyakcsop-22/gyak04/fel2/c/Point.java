

public class Point
{
    private double x;
    private double y;
    private int id;

    // statikus adattag, osztályszintű adattag: logikailag a Point osztályhoz tartozik
    // nem pedig egy konkrét objektumhoz

    // a Point osztály összes példánya megosztottan használja a current_id statikus adattagot:
    // a program futása során egyetlen int current_id; változó létezik, így minden példány
    // amikor hivatkozik current_id-ra, az előző használó példány által beállított
    // értéket olvassa ki

    // hasonlít a C globális változóihoz
    private static int current_id = 0;

    public Point(double init_x, double init_y)
    {
        x = init_x;
        y = init_y;
        id = current_id;
        ++current_id;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public void move(int dx, int dy)
    {
        x += dx;
        y += dy;
    }

    public void mirror(Point center)
    {
        x = 2*center.x - x;
        y = 2*center.y - y;
    }

    public double distance(Point p)
    {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }

    public String toString()
    {
        return id + ":(" + x + "," + y + ")";
    }

    public static Point centerOfMass(Point[] array)
    {
        double sum_x = 0;
        double sum_y = 0;
        for (int i = 0; i < array.length; ++i)
        {
            sum_x += array[i].getX();
            sum_y += array[i].getY();
        }
        Point center = new Point(sum_x / array.length, sum_y / array.length);
        return center;
    }
};
