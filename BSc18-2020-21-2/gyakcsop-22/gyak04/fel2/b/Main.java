

class Main
{
    public static void main(String[] args)
    {
        Point[] array = new Point[3];
        array[0] = new Point(2, 3);
        array[1] = new Point(1, 1);
        array[2] = new Point(5, 2);

        // statikus metódus hívása
        System.out.println("mass of points = " + Point.centerOfMass(array));
    }
}

