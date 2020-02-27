

package circle;


public class Main
{
    public static void main(String[] args)
    {
        Circle c1 = new Circle(3, 5, 10);
        //c1.center = new circle.utils.Point();
        //c1.center.x = 3;
        //c1.center.y = 5;
        //c1.radius = 10;
        System.out.println(c1.toString());
        c1.enlarge(3);
        System.out.println(c1);
    }
}

