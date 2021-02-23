package circle.utils;


public class Point
{
    private double x;
    private double y;

    public void setX(double new_x)
    {
        x = new_x;
    }

    public void setY(double new_y)
    {
        y = new_y;
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
};
