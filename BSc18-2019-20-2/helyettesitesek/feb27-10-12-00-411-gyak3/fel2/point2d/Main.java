
package point2d;


class Main
{
    public static void main(String[] args)
    {
        Point p = new Point();
        p.x = 1;
        p.y = 2;
        p.move(3, 5);
        System.out.println("p x = " + p.x + ", y = " + p.y);
        
        Point p2 = new Point();
        p2.x = 4;
        p2.y = -1;
        p.mirror(p2);
        System.out.println("p x = " + p.x + ", y = " + p.y);
        
        System.out.println("distance = " + p.distance(p2));
    }
}
