
// névtelen package: nincs package név;
// a névtelen csomagból semmi nem látszik ki


public class Main
{
    public static void main(String[] args)
    {
        Point[] arr = new Point[3];
        arr[0] = new Point(1, 2);
        arr[1] = new Point(10, 2);
        arr[2] = new Point(-4, 4);

        double center_x = 0, center_y = 0;
        for (int i = 0; i < arr.length; ++i)
        {
            center_x += arr[i].getX();
            center_y += arr[i].getY();
        }
        Point center = new Point(center_x / arr.length, center_y / arr.length);
        System.out.println(center);
    }
}

