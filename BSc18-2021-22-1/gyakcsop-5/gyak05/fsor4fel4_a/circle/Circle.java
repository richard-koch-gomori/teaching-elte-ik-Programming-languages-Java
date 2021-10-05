// Java nyelv konvenció (megszokásai):
// csomagnevek: csupa kisbetűvel
// osztálynevek kezdő nagybetűvel

package circle;

import circle.utils.Point;


public class Circle
{
    private double x = 0;
    private double y = 0;
    private double radius = 1;

    public Circle(double init_x, double init_y, double init_radius)
    {
        x = init_x;
        y = init_y;

        if (init_radius <= 0)
        {
            System.out.println("radius must be pos");
            System.exit(1);
        }
        radius = init_radius;
    }

    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    public String toString()
    {
        return "(" + x + "," + y + "), r = " + radius;
    }

    // visszaadja a kör középpontját Point típusú adatban
    public Point getCenter()
    {
        Point result = new Point();
        result.setX(x);
        result.setY(y);
        return result;
    }
}


