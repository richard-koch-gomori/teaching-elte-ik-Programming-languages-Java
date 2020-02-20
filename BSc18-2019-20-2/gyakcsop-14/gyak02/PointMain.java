

// az osztály deklarációja: leírja az adattagokat (itt x, y) és metódusainak (~member function) implementációját
class Point
{
    public double x;
    public double y;

    public void move(double dx, double dy)
    {
        // ez a sor 6. sorban deklarált x változót éri el
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
        p.y = 4;
        p.move(2, 4); // az objektum move() metódusának hívása
        p.mirror(1, 3);
        System.out.println("p x = " + p.x + ", y = " + p.y);

        Point p2 = new Point();
        p2.x = -1;
        p2.y = -1;
        p.mirror(p2);
        System.out.println("p x = " + p.x + ", y = " + p.y);

        p.move(1, 2);
    }
}


// fontos különbség: osztály vs objektum
// osztály: class Point {}; az adattagok és metódusok leírása
// objektum: az osztály egy példánya; ami létezik a memóriaterületen, lehet rá hivatkozni


