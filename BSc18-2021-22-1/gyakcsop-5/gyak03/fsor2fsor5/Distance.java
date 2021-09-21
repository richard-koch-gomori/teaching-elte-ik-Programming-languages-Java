

class Point
{
    double x;
    double y;

    double distance(Point p)
    {
        return Math.sqrt( Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2) );
    }

    /*public static void main(String[] args)
    {
        System.out.println("Im Point");
    }*/
}

class Distance
{
    public static void main(String[] args)
    {
        double res = 0;
        for (int i = 0; i < args.length - 2; i += 2)
        {
            // 0. 1. 2. 3.
            System.out.println("i = " + i);
            /*System.out.println(args[i]);
            System.out.println(args[i + 1]);
            System.out.println(args[i + 2]);
            System.out.println(args[i + 3]);*/

            Point p = new Point();
            p.x = Double.parseDouble(args[i]);
            p.y = Double.parseDouble(args[i + 1]);

            Point p2 = new Point();
            p2.x = Double.parseDouble(args[i + 2]);
            p2.y = Double.parseDouble(args[i + 3]);

            res += p.distance(p2);
        }
        System.out.println("res = " + res);
    }
}

