
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

interface Reversable
{
    void reverse();
}

// leszármazás osztályból és interface megvalósítása
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
        super.setY(y);
    }

    public String toString()
    {
        return "(" + getX() + "," + getY() + ")";
    }

    @Override
    public void reverse()
    {
        setX(last_x);
        setY(last_y);
    }
}

interface Printable
{
    abstract void print();
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

class PrintablePoint extends Point implements Printable
{
    public PrintablePoint(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void print()
    {
        System.out.println("(" + getX() + "," + getY() + ")");
    }
}

class PrintableAndReverseablePoint extends Point implements Printable, Reversable
{
    private int last_x, last_y;

    public PrintableAndReverseablePoint(int x, int y)
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
    public void print()
    {
        System.out.println("(" + getX() + "," + getY() + ")");
    }

    @Override
    public void reverse()
    {
        setX(last_x);
        setY(last_y);
    }
}

class Main
{
    public static void foo(Printable p)
    {
        // ...
        p.print();
    }

    public static void main(String[] args)
    {
        ReversablePoint p = new ReversablePoint(2, 3);
        System.out.println(p);
        p.setX(10);
        System.out.println(p);
        p.reverse();
        System.out.println(p);

        PrintableBook b = new PrintableBook("a", "t");
        b.print();

        PrintablePoint pp = new PrintablePoint(2, 5);
        foo(b);
        foo(pp);

        PrintableAndReverseablePoint f = new PrintableAndReverseablePoint(4, 5);
        f.reverse();
        f.print();
    }
}
