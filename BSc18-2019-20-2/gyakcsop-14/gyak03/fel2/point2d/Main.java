

package point2d;


class Main
{
    public static void main(String[] args)
    {
        Point p = new Point();
        p.x = 1;
        p.y = 4;
        p.move(2, 4);
        p.mirror(1, 3);
        System.out.println("p x = " + p.x + ", y = " + p.y);

        Point p2 = new Point();
        p2.x = -1;
        p2.y = -1;
        p.mirror(p2);
        System.out.println("p x = " + p.x + ", y = " + p.y);

        p.move(1, 2);
    }
}



