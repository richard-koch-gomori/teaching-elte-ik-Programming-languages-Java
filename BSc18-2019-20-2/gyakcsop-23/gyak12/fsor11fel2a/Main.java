
interface Reversable
{
    void reverse();
}

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

class Main
{
    public static void foo(Printable p)
    {
        //
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


/*
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

class Book
{
    private String author, title;

    public Book(String author, String title)
    {
        this.author = author;
        this.title = title;
    }
}

class Main
{
    public static void main(String[] args)
    {

    }
}

*/