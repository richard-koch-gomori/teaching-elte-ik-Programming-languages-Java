
// a közös kód kiemelése egy ősosztályba
class Point
{
    private int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public int getX() { return x; }
    public int getY() { return y; }
}

interface Printable
{
    void print();
}

// leszármazás osztályból és interface megvalósítása
class PrintablePoint extends Point implements Printable
{
    public PrintablePoint(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void print()
    {
        System.out.println("(" + super.getX() + "," + super.getY() + ")");
    }
}

class PrintableBook implements Printable
{
    private String author, title;

    public PrintableBook(String author, String title)
    {
        this.author = author;
        this.title = title;
    }

    @Override
    public void print()
    {
        System.out.println(author + ": " + title);
    }
}

interface Reversable
{
    void reverse();
}

class ReversablePoint extends Point implements Reversable
{
    private int last_x, last_y;

    public ReversablePoint(int x, int y)
    {
        // egy konstruktor első utasítása (akár kiírjuk akár nem) mindig az ősosztály paraméter nélküli konstruktorát hívó super() hívás
        // itt most explicit ki kell írni, mert az x,y adatokat az ősosztály konstruktorával tároljuk
        // a gyakorlaton a hibaüzenet abból származott, hogy az ősosztálynak nincs paraméter nélküli konstruktora
        super(x, y);
        last_x = x;
        last_y = y;
    }
    public void setX(int x)
    {
        last_x = getX();
        super.setX(x); // az ősosztály setX() metódusának hívása
    }
    public void setY(int y)
    {
        last_y = getY();
        super.setX(y);
    }

    public String toString()
    {
        return "(" + getX() + "," + getY() + ")";
    }

    @Override
    public void reverse()
    {
        super.setX(last_x);
        super.setY(last_y);
    }
}

class PrintableAndReversablePoint extends Point implements Reversable, Printable
{
    private int last_x, last_y;

    public PrintableAndReversablePoint(int x, int y)
    {
        super(x, y);
        last_x = x;
        last_y = y;
    }
    public void setX(int x)
    {
        last_x = getX();
        super.setX(x);
    }
    public void setY(int y)
    {
        last_y = getY();
        super.setY(y);
    }

    @Override
    public void reverse()
    {
        super.setX(last_x);
        super.setY(last_y);
    }

    @Override
    public void print()
    {
        System.out.println("(" + getX() + "," + getY() + ")");
    }
}

/*
interface PrintableAndReversable extends Printable, Reversable
{
}

class PrintableAndReversablePoint implements PrintableAndReversable
{
    // ...
}
*/



class Main
{
    public static void foo(Printable obj)
    {
        // ...
        obj.print();
    }

    /*
    public static void foo(PrintableAndReversable obj)
    {
        // ...
        obj.print();
    }
    */

    public static void main(String[] args)
    {
        PrintablePoint p1 = new PrintablePoint(2, 5);
        //p1.print();
        PrintableBook b1 = new PrintableBook("aut", "ttit");
        //b1.print();
        foo(p1);
        foo(b1);

        ReversablePoint p2 = new ReversablePoint(2, 3);
        System.out.println(p2);
        p2.setX(10);
        System.out.println(p2);
        p2.reverse();
        System.out.println(p2);

        PrintableAndReversablePoint pp = new PrintableAndReversablePoint(2, 10);
        pp.print();
        pp.reverse();
    }
}