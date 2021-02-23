package pointm;


// teljesen minősített név
// fully qualified name:
// csomagnév.osztálynév
// pointm.PointMain
class PointMain
{
    public static void main(String[] args)
    {
        point2d.Point p1;

        p1 = new point2d.Point();

        p1.x = 5;
        p1.y = -1;

        System.out.println("p1: x = " + p1.x + ", y = " + p1.y);

        point2d.Point p2 = new point2d.Point();
        p2.x = 10;
        p2.y = 20;
        System.out.println("p2: x = " + p2.x + ", y = " + p2.y);

        System.out.println("distance between p1 and p2 = " + p1.distance(p2));
    }
}

