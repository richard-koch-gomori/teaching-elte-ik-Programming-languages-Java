

class Circle
{
    private double x;
    private double y;
    private double radius;

    // konstruktor
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
}

public class CircleMain
{
    public static void main(String[] args)
    {
        // legyen Circle-nek konstruktora, és a konstruktor végezze a szükséges inicializálásokat
        Circle c = new Circle(5, 2, 10);
        System.out.println("area = " + c.getArea());
    }
}

