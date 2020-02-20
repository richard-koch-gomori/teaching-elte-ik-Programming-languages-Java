

public class Circle
{
    public double x, y;
    public double radius;

    public void enlarge(double f)
    {
        radius *= f;
    }

    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    // a Circle osztálynak akkor is lenne toString()-je, ha itt nem adnánk meg (később tanuljuk miért)
    public String toString()
    {
        return "(" + x + "," + y + "), r = " + radius;
    }
}

