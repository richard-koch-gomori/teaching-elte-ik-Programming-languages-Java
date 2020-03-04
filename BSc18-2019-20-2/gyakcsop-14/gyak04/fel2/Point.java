

public class Point
{
    private double x;
    private double y;

    public double getX() { return x; }
    public double getY() { return y; }

    public Point(double init_x, double init_y)
    {
        x = init_x;
        y = init_y;
    }

    public void move(double dx, double dy)
    {
        x += dx;
        y += dy;
    }

    public void mirror(double cx, double cy)
    {
        x = 2 * cx - x;
        y = 2 * cy - y;
    }

    public void mirror(Point that)
    {
        x = 2 * that.x - x;
        y = 2 * that.y - y;
    }

    public String toString()
    {
        return "(" + x + "," + y + ")";
    }

    // statikus metódus: logikailag a Point osztályhoz tartozik, de nem egy konkrét objektum adattagjaival dolgozik
    public static Point centerOfMass(Point[] arr)
    {
        double center_x = 0, center_y = 0;
        for (int i = 0; i < arr.length; ++i)
        {
            center_x += arr[i].getX();
            center_y += arr[i].getY();
        }
        Point center = new Point(center_x / arr.length, center_y / arr.length);
        return center;
    }
}

