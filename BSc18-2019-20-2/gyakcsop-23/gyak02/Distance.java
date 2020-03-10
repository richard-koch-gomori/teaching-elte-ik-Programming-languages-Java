

class Point
{
    public double x, y;

    public void move(double dx, double dy)
    {
        x += dx;
        y += dy;
    }

    public void mirror(double cx, double cy)
    {
        x = 2 * cx - x;
        y = 2 * cy - y;
    }

    public void mirror(Point that)
    {
        x = 2 * that.x - x;
        y = 2 * that.y - y;
    }

    public double distance(Point that)
    {
        double dx = x - that.x;
        double dy = y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
}

class Distance
{
    public static void main(String[] args)
    {
        double res = 0;
        for (int i = 0; i < args.length - 2; i += 2)
        {
            Point p1 = new Point();
            p1.x = Integer.parseInt(args[i]);
            p1.y = Integer.parseInt(args[i + 1]);
            Point p2 = new Point();
            p2.x = Integer.parseInt(args[i + 2]);
            p2.y = Integer.parseInt(args[i + 3]);
            res += p1.distance(p2);
        }
        System.out.println("res = " + res);
    }
}

