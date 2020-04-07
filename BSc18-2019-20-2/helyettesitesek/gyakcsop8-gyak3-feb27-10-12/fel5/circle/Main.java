
package circle;


public class Main
{
    public static void main(String[] args)
    {
        Circle c1 = new Circle(1, 2, 10);
        //c1.center.x = 1;
        //c1.center.y = 2;
        //c1.radius = 10;
        System.out.println(c1.toString());
        c1.enlarge(3);
        System.out.println(c1);
    }
}

