

class Circle
{
    public double x, y;
    public double radius;

    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    public void enlarge(double f)
    {
        radius = f * radius;
    }
}


class CircleMain
{
    public static void main(String[] args)
    {
        Circle c = new Circle();
        c.x = 1;
        c.y = 2;
        c.radius = 5;
        c.enlarge(10);
        System.out.println("area: " + c.getArea());
    }
}

