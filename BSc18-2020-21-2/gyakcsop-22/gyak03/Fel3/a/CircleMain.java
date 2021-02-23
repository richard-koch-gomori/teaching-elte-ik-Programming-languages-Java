

class Circle
{
    public double x = 0;
    public double y = 0;
    public double radius = 1;

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
        // a Circle felhasználója könnyen elronthatja a Circle adattagjait (belső állapotát)
        // így a Circle osztályt könnyű rosszul használni -> megoldás: Circle adattagjait csak jól megírt setter és getter metódusok érhetik el (b)
        c.x = 5;
        c.y = 2;
        c.radius = 10;
        System.out.println("area = " + c.getArea());
    }
}

