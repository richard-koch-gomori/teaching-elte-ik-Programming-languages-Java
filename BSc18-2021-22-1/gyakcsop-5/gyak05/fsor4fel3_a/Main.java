

class Circle
{
    public double x = 0;
    public double y = 0;
    public double radius = 1;

    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    public String toString() // sztringben visszaadja a Circle adatait
    {
        // "(x, y), r = ..."
        return "(" + x + "," + y + "), r = " + radius;
    }
}

// felhasználó kód (user code)
public class Main
{
    public static void main(String[] args)
    {
        Circle c1 = new Circle();
        c1.x = 5;
        c1.y = 2;
        c1.radius = 10;
        //System.out.println("c1 = " + c1.toString());
        System.out.println("c1 = " + c1); // ha nem írjuk ki, a println() odaérti a .toString() -et
        System.out.println("area = " + c1.getArea());
    }
}

