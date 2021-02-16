
class Circle
{
    double x, y;
    double radius;

    void enlarge(double f)
    {
        radius = radius * f;
        //radius *= f;
    }

    double getArea()
    {
        return Math.pow(radius, 2) * Math.PI;
    }
}

class CircleMain
{
    public static void main(String[] args)
    {
        Circle c = new Circle();
        c.x = 6;
        c.y = 3;
        c.radius = 2;

        System.out.println("area = " + c.getArea());
        c.enlarge(1);
        System.out.println("area = " + c.getArea());
        c.enlarge(2);
        System.out.println("area = " + c.getArea());
    }
}

