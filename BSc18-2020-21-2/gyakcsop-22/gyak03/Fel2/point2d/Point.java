package point2d;


// public class jelentése: a Point osztály látszódjon ki a point2d csomagból
// (azaz a point2d csomagon kívüli felhasználók (csomagok, osztályok, user code) számára a Point osztály hozzáférhető)
public class Point
{
    // public adattag és public metódus: mindenki számára elérhető
    public int x;
    public int y;

    public void move(int dx, int dy)
    {
        x += dx;
        y += dy;
    }

    public void mirror(Point center)
    {
        x = 2*center.x - x;
        y = 2*center.y - y;
    }

    public double distance(Point p)
    {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }
};

// a public kulcsszó nélkül a deklarált név csak abban a csomagban érhető el,
// amelyikben deklarálták (package-private)
