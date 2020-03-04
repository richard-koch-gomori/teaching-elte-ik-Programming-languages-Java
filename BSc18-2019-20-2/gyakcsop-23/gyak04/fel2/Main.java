

public class Main
{
    public static void main(String[] args)
    {
        Point[] arr = new Point[3];
        arr[0] = new Point(1, 2);
        arr[1] = new Point(10, 2);
        arr[2] = new Point(-4, 4);

        // statikus metódus hívása
        Point center = Point.centerOfMass(arr);

        System.out.println(center);
    }
}

