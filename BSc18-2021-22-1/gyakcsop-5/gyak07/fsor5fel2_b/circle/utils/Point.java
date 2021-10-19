package circle.utils; // csomag csomagon belül


public class Point
{
    private double x;
    private double y;

    public double getX() { return x; }
    public double getY() { return y; }

    public void setX(double init_x) { x = init_x; }

    public Point(double init_x, double init_y)
    {
        x = init_x;
        y = init_y;
    }

    public double distance(Point p)
    {
        return Math.sqrt( Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2) );
    }

    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
    
    // static: metódus/adattag nem egy konkrét Point objektumhoz tartozik, hanem a Point osztályhoz
    // egyedi, az összes Point objektum megosztva használja
    // mivel nem egy konkrét objektum adattagjaival dolgozik, ezen függvényen belül
    // az x vagy y-ra való hivatkozás fordítási hibát ad
    public static Point getCenter(Point[] array)
    {
        double sum_x = 0;
        double sum_y = 0;
        for (int i = 0; i < 3; ++i)
        {
            sum_x += array[i].getX();
            sum_y += array[i].getY();
        }
        Point center = new Point(sum_x / 3, sum_y / 3);
        return center;
    }
}
