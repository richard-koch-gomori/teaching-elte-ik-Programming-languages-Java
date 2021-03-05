

class Main
{
    public static void main(String[] args)
    {
        Point[] array = new Point[3];
        array[0] = new Point(2, 3); // id == 0
        array[1] = new Point(1, 1); // id == 1
        array[2] = new Point(5, 2); // id == 2

        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);

        System.out.println("mass of points = " + Point.centerOfMass(array));
    }
}

