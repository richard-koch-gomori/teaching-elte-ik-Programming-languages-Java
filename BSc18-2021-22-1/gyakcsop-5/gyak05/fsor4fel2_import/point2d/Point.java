package point2d;

public class Point
{
    public double x;
    public double y;

    public double distance(Point p)
    {
        return Math.sqrt( Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2) );
    }
}

