package point2d;

// teljesen minősített név (fully qualified name): point2d.Point
public class Point // ha nem írunk public kulcsszót, akkor Point láthatósága: package-private: csak az azonos csomagban lehet elérni

// public: mindenki számra elérhető
{
    public double x;
    public double y;

    public double distance(Point p)
    {
        return Math.sqrt( Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2) );
    }
}

