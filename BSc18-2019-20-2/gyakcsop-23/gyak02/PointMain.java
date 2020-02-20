


// az osztály deklarációja: leírja az adattagokat (itt x, y) és metódusainak (~member function) implementációját
class Point
{
    public double x, y;

    public void move(double dx, double dy)
    {
        // ez a sor 7. sorban deklarált x változót éri el
        x += dx;

        y += dy;
    }

    public void mirror(double cx, double cy)
    {
        x = 2 * cx - x;
        y = 2 * cy - y;
    }

    public void mirror(Point that)
    {
        x = 2 * that.x - x;
        y = 2 * that.y - y;
    }

    // function overloading: ugyanolyan néven, de más paraméterlistával definiálhatunk több függvényt, amelyekhez más implementáció tartozik
    // a függvényhívásnál a fordító az argumentumokból fogja kikövetkeztetni, melyik mirror() implementációt kell meghívni

    public double distance(Point that)
    {
        double dx = x - that.x;
        double dy = y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
}


class PointMain
{
    public static void main(String[] args)
    {
        //Point p;
        // Point p; esetén, ha Point nem primitív (azaz nem int, double etc)
        // akkor nem jön létre objektum
        // ez csak egy referencia, aminek nem adtunk értéket
        // referencia: hasonló a pointer-hez, memóriacímet tartalmaz, de nem kell jelölni (nincs Point*), nincs dereferálás

        // a Point osztály példányosítása:
        // a heap-en jön létre egy Point objektum
        // Point p egy referencia, aminek értékül adjuk a heap-en létrejött objektum referenciáját (memóriacímét)
        Point p = new Point();

        // ha van egy p referenciám, akkor azon a pont (.) operátorral lehet mezőhivatkozásokat vagy metódushívást csinálni
        p.x = 1; // az objektum x mezőjének elérése
        p.y = 2;
        p.move(3, 5); // az objektum move() metódusának hívása
        System.out.println("p x = " + p.x + ", y = " + p.y);

        Point p2 = new Point();
        p2.x = 4;
        p2.y = -1;
        p.mirror(p2);
        System.out.println("p x = " + p.x + ", y = " + p.y);

        System.out.println("distance = " + p.distance(p2));
    }
}


// fontos különbség: osztály vs objektum
// osztály: class Point {}; az adattagok és metódusok leírása
// objektum: az osztály egy példánya; ami létezik a memóriaterületen, lehet rá hivatkozni

