

class Circle
{
    private double x = 0;
    private double y = 0;
    private double radius = 1;

    // konstruktor
    // nincs visszatérési értéke
    // ugyanaz a neve mint az osztály nevének
    // az objektum példányosításakor (new-zásakor) fut le
    public Circle(double init_x, double init_y, double init_radius)
    {
        x = init_x;
        y = init_y;

        if (init_radius <= 0)
        {
            System.out.println("radius must be pos");
            System.exit(1); // leállítja a program futását, 1-es exitkóddal
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
}

public class Main
{
    public static void main(String[] args)
    {
        Circle c1 = new Circle(5, 2, 10);
        //System.out.println("c1 = " + c1.toString());
        System.out.println("c1 = " + c1);
        System.out.println("area = " + c1.getArea());
    }
}

