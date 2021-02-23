package circle;

import circle.utils.Point;


public class Circle
{
    private double x;
    private double y;
    private double radius;

    public Circle(double init_x, double init_y, double init_radius)
    {
        x = init_x;
        y = init_y;
        radius = init_radius;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getRadius()
    {
        return radius;
    }

    public double getArea()
    {
        return Math.pow(radius, 2) * Math.PI;
    }

    public Point getCenter()
    {
        Point center = new Point();
        center.setX(x);
        center.setY(y);
        return center;
    }
}

