

package pointm;

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

            point2d.Point p = new point2d.Point();
            p.x = Double.parseDouble(args[i]);
            p.y = Double.parseDouble(args[i + 1]);

            point2d.Point p2 = new point2d.Point();
            p2.x = Double.parseDouble(args[i + 2]);
            p2.y = Double.parseDouble(args[i + 3]);

            res += p.distance(p2);
        }
        System.out.println("res = " + res);
    }
}

