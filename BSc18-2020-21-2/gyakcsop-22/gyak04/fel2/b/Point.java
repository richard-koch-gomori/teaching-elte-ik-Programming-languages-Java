

public class Point
{
    private double x;
    private double y;

    public Point(double init_x, double init_y)
    {
        x = init_x;
        y = init_y;
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
        return "(" + x + "," + y + ")";
    }

    // statikus metódus, osztályszintű metódus: logikailag a Point osztályhoz tartozik,
    // de nem egy konkrét objektum adattagjaival dolgozik
    // hasonlít a C globális függvényeihez
    // mivel nem egy konkrét objektum adattagjaival dolgozik, ezen függvényen belül
    // az x vagy y-ra való hivatkozás fordítási hibát ad
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


// minden metódust, ami nem "static", szokás objektumszintű metódusnak nevezni
// mert azt egy konkrét objektumon hívták: változónév.metódusnév()
// így az objektumszintű metódus azon objektum adattagjait ér el, amelyiken meghívták

