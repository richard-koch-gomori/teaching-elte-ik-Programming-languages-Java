package circle.utils; // csomag csomagon belül


public class Point
{
    private double x;
    private double y;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Point(Point other)
    {
        this.x = other.x;
        this.y = other.y;
    }

    // setter
    public void setX(double new_x) { x = new_x; }
    public void setY(double new_y) { y = new_y; }

    // getter
    public double getX() { return x; }
    public double getY() { return y; }

    private double distance(Point p)
    {
        return Math.sqrt( Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2) );
    }
}
