

class Point
{
    int x;
    int y;

    void move(int dx, int dy)
    {
        x += dx;
        y += dy;
    }

    void mirror(Point center)
    {
        x = 2*center.x - x;
        y = 2*center.y - y;
    }

    double distance(Point p)
    {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }
};


class Distance
{
    public static void main(String[] args)
    {
        double distance = 0;
        for (int i = 0; i < args.length - 2; i += 2)
        {
            Point p1 = new Point();
            p1.x = Integer.parseInt(args[i]);
            p1.y = Integer.parseInt(args[i + 1]);

            Point p2 = new Point();
            p2.x = Integer.parseInt(args[i + 2]);
            p2.y = Integer.parseInt(args[i + 3]);

            distance += p1.distance(p2);
        }

        System.out.println(distance);
    }
}

