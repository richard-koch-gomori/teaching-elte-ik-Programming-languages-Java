package circle.utils;


public class Point
{
    private double x;
    private double y;
    private int id;
    
    // statikus adattag, osztályszintű adattag: logikailag a Point osztályhoz tartozik
    // nem pedig egy konkrét objektumhoz

    // a Point osztály összes példánya megosztottan használja a counter statikus adattagot:
    // a program futása során egyetlen int counter; változó létezik, így minden példány
    // amikor hivatkozik counter-ra, az előző használó példány által beállított
    // értéket olvassa ki
    private static int counter = 1;

    public double getX() { return x; }
    public double getY() { return y; }

    public void setX(double init_x) { x = init_x; }

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;

        id = counter;
        counter++;

        // id = counter++;
    }

    public double distance(Point p)
    {
        return Math.sqrt( Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2) );
    }

    public String toString()
    {
        return id + ": (" + x + "," + y + ")";
    }
    
    public static Point getCenter(Point[] array)
    {
        double sum_x = 0;
        double sum_y = 0;
        for (int i = 0; i < 3; ++i)
        {
            sum_x += array[i].x;
            sum_y += array[i].y;
        }
        Point center = new Point(sum_x / 3, sum_y / 3);
        return center;
    }
}
