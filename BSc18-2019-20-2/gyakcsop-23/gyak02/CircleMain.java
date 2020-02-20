

public class CircleMain
{
    public static void main(String[] args)
    {
        Circle c1 = new Circle();
        c1.x = 3;
        c1.y = 5;
        c1.radius = 10;
        System.out.println(c1.toString());
        c1.enlarge(3);
        System.out.println(c1); // c1.toString(); hívódik meg
    }
}

