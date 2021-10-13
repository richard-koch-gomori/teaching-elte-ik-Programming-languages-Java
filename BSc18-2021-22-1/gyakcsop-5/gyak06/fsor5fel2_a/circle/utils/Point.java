package circle.utils; // csomag csomagon belül


public class Point
{
    private double x;
    private double y;

    public double getX() { return x; }
    public double getY() { return y; }

    public void setX(double init_x) { x = init_x; }

    public Point(double init_x, double init_y)
    {
        x = init_x;
        y = init_y;
    }

    public double distance(Point p)
    {
        return Math.sqrt( Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2) );
    }

    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
}
