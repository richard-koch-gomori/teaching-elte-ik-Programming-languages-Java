// Jónás Bendegúz Gergő megoldása Koch-Gömöri Richárd kommentjeivel

interface Reversable
{
    void reverse();
}

interface Printable
{
    void print();
}

class Point
{
    protected int x, y;

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
}

class ReversablePoint extends Point implements Reversable 
{
    private int prevX, prevY;

    public ReversablePoint(int x, int y)
    {
        super(x, y);
        prevX = x;
        prevY = y;
    }

    @Override
    public void reverse()
    {
        // visszaállítja az objektum belső állapotát
        x = prevX;
        y = prevY;
    }

    public void setX(int x)
    {
        prevX = this.x; 
        this.x = x;
    }

    public void setY(int y)
    {
        prevY = this.y;
        this.y = y;
    }

    public String toString()
    {
        return x + " " + y;
    }
}

// nagyon fontos különbség az absztrakt osztályokhoz képest:
// egy osztály csak egy osztályból származhat le, de több interface-t is implementálhat
class PrinatableAndReversablePoint extends Point implements Reversable, Printable
{
    private int prevX, prevY;

    public PrinatableAndReversablePoint(int x, int y)
    {
        super(x, y);
        prevX = x;
        prevY = y;
    }

    @Override
    public void reverse()
    {
        x = prevX;
        y = prevY;
    }

    @Override
    public void print()
    {
        System.out.println(x + " " + y);
    }

    public void setX(int x)
    {
        prevX = this.x; 
        this.x = x;
    }

    public void setY(int y)
    {
        prevY = this.y;
        this.y = y;
    }

    public String toString()
    {
        return x + " " + y;
    }
}

class Main
{
    public static void main(String[] args)
    {
        ReversablePoint r = new ReversablePoint(1, 2);
        r.setX(10);
        System.out.println(r);
        r.reverse();
        System.out.println(r);

        System.out.println("--------------------");

        PrinatableAndReversablePoint pr = new PrinatableAndReversablePoint(2, 2);
        pr.setX(10);
        pr.print();
        pr.reverse();
        pr.print();

        System.out.println("--------------------");

        Printable x = new PrinatableAndReversablePoint(1, 69);
        x.print();       // lefordul       - x statikus típusa Printable
        //x.reverse();   // nem fordul le  - Printable nem ismer reverse() metódust
    }
}


