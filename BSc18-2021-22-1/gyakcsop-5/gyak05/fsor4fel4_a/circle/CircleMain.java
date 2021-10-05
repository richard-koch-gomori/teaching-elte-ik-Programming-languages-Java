package circle;

// teljesen minősített neve: circle.CircleMain
public class CircleMain
{
    public static void main(String[] args)
    {
        Circle c1 = new Circle(5, 2, 10);
        //System.out.println("c1 = " + c1.toString());
        System.out.println("c1 = " + c1);
        System.out.println("area = " + c1.getArea());
    }
}


