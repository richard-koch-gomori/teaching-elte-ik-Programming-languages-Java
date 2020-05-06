interface Printable
{
    void print();
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

class ReversablePoint implements Reversable
{
    private int x;
    private int y;
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
        x = last_x;
        y = last_y;
    }
}

class PrintableAndReversablePoint implements Reversable, Printable
{
    private int x, y;
    private int last_x, last_y;

    public PrintableAndReversablePoint(int x, int y)
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
    public void reverse()
    {
        x = last_x;
        y = last_y;
    }

    @Override
    public void print()
    {
        System.out.println("(" + x + "," + y + ")");
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