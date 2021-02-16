
/*
primitív típus:
- 8 típus: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

nem primitív típus:
- MINDEN más
- pl. String
- heap-en tárolódnak, ált. new-val hozzuk létre
*/



// osztálydefiníció
// Point: x és y adataggjai
class Point
{
    int x;
    int y;

    // metódus
    // a pont koordinátáit eltolja dx-el ill. dy-al
    void move(int dx, int dy)
    {
        x += dx;
        y += dy;
    }

    void mirror(int cx, int cy)
    {
        x = 2*cx - x;
        y = 2*cy - y;
    }
};

class PointMain
{
    public static void main(String[] args)
    {
        // p1: referencia
        Point p1;

        // Point példányosítása
        p1 = new Point(); // new -- C: malloc()
        // p1 mutat a heap-en a Point objektumra
        //egy sorban: Point p1 = new Point();

        // adattag elérés: a p1 x adattagját érjük el
        p1.x = 5;
        p1.y = -1;

        System.out.println("p1: x = " + p1.x + ", y = " + p1.y);

        // metódushívás
        // a p1-en hívjuk meg mirror()-t
        p1.mirror(1, 1);
        System.out.println("p1 after mirror: x = " + p1.x + ", y = " + p1.y);

        p1.move(1, 2);
        System.out.println("p1 after move: x = " + p1.x + ", y = " + p1.y);

        Point p2 = new Point();
        p2.x = 10;
        p2.y = 20;
        System.out.println("p2: x = " + p2.x + ", y = " + p2.y);
    }
}

