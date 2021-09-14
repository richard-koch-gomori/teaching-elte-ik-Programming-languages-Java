

// osztály: leírja az adattagokat és metódusokat
// neve: Point
class Point
{
    int x; // adattag
    int y; // adattag

    // metódus
    void move(int dx, int dy)
    {
        x = x + dx;
        //x += dx;
        y = y + dy;
    }

    // P(x, y)
    // C(cx, cy)
    // P tükrözve C-re (2 * cx - x, 2 * cy - y)
    void mirror(int cx, int cy)
    {
        x = 2*cx - x;
        y = 2*cy - y;
    }
}

class Main
{
    public static void main(String[] args)
    {
        Point p;
        p = new Point(); // a heap-en létrejön egy Point objektum, példányosítás; p: változó
        p.x = 5; // adattag elérés: a p x adattagját érjük el
        p.y = 10;
        p.move(2, 3); // metódushívás: a p -n hívjuk meg mirror() -t
        System.out.println("p.x = " + p.x + ", p.y = " + p.y);

        Point p2 = new Point();
        p2.x = 2;
        p2.y = -1;
        p2.move(-1, -1);
        System.out.println("p2.x = " + p2.x + ", p2.y = " + p2.y);

        System.out.println("-------------------");
        System.out.println("p.x = " + p.x + ", p.y = " + p.y);
        p.mirror(0, 0);
        System.out.println("p.x = " + p.x + ", p.y = " + p.y);
    }
}

/*
EA
Hogy néz ki a metódushivás?
helyes: változónév.metódus()
*/

