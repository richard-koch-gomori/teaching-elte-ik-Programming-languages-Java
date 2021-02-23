package point2d;


public class Point
{
    public int x;
    public int y;

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


