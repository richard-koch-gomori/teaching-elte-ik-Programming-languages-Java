
// interface: absztrakt publikus metódus szignatúrákat tartalmaz
interface Reversable
{
    void reverse();
}

// ReversablePoint megvalósítja az interface-t, kötelező implementálni az interface metódusait
class ReversablePoint implements Reversable
{
    private int x, y;
    private int last_x, last_y;

    public ReversablePoint(int x, int y)
    {
        last_x = this.x = x;
        last_y = this.y = y;
    }

    public void setX(int x)
    {
        last_x = this.x;
        this.x = x;
    }
    public void setY(int y)
    {
        last_y = this.y;
        this.y = y;
    }
    public int getX() { return x; }
    public int getY() { return y; }

    public String toString()
    {
        return "(" + x + "," + y + ")";
    }

    @Override
    public void reverse()
    {
        // visszaállítja az objektum belső állapotát
        x = last_x;
        y = last_y;
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

class PrintablePoint implements Printable
{
    private int x, y;

    public PrintablePoint(int x, int y)
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

    @Override
    public void print()
    {
        System.out.println("(" + x + "," + y + ")");
    }
}

// nagyon fontos különbség az absztrakt osztályokhoz képest:
// egy osztály csak egy osztályból származhat le, de több interface-t is implementálhat
class PrintableAndReverseablePoint implements Printable, Reversable
{
    private int x, y;
    private int last_x, last_y;

    public PrintableAndReverseablePoint(int x, int y)
    {
        last_x = this.x = x;
        last_y = this.y = y;
    }

    public void setX(int x)
    {
        last_x = this.x;
        this.x = x;
    }
    public void setY(int y)
    {
        last_y = this.y;
        this.y = y;
    }
    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public void print()
    {
        System.out.println("(" + x + "," + y + ")");
    }

    @Override
    public void reverse()
    {
        x = last_x;
        y = last_y;
    }
}

//interface PrintableAndReverseable extends Printable, Reversable
//{
//}

//class PrintableAndReverseablePoint extends Point implements PrintableAndReverseable
//{
//    ...
//}

class Main
{
    // több osztály is implementálhatja ugyanazt az interface-t
    // a foo() metódus olyan osztály objektumát várja, aki implementálja a Printable interface-t
    public static void foo(Printable p)
    {
        // ...
        p.print(); // kihasználhatjuk, hogy p "tudja a" Printable-t
    }

    /*
    // olyan paraméter, ami több interface-t implementál
    public static void foo2(PrintableAndReverseable obj)
    {
        // ...
        obj.print();
    }
    */

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

