
package circle.utils;


public class Point
{
    private double x, y;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
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
    
    public double distance(Point that)
    {
        double dx = x - that.x;
        double dy = y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
}

