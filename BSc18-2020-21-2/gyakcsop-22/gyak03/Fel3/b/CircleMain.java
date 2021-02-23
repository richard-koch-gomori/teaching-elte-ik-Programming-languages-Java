

class Circle
{
    // private adattag és private metódus: csak Circle metódusai férhetnek hozzá
    private double x = 0;
    private double y = 0;
    private double radius = 1;

    public void setX(double new_x)
    {
        x = new_x;
    }

    public void setY(double new_y)
    {
        y = new_y;
    }

    public void setRadius(double new_radius)
    {
        if (new_radius <= 0)
        {
            System.exit(1);
            //throw new IllegalArgumentException();
        }
        radius = new_radius;
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
}

public class CircleMain
{
    public static void main(String[] args)
    {
        Circle c = new Circle();
        System.out.println("area = " + c.getArea());
        c.setX(5);
        c.setY(2);
        c.setRadius(-10);
        System.out.println("area = " + c.getArea());
    }
}

