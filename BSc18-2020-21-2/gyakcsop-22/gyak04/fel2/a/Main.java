

class Main
{
    public static void main(String[] args)
    {
        Point[] array = new Point[3];
        array[0] = new Point(2, 3);
        array[1] = new Point(1, 1);
        array[2] = new Point(5, 2);

        double sum_x = 0;
        double sum_y = 0;
        for (int i = 0; i < array.length; ++i)
        {
            sum_x += array[i].getX();
            sum_y += array[i].getY();
        }
        Point center = new Point(sum_x / array.length, sum_y / array.length);
        System.out.println("mass of points = " + center);
    }
}

