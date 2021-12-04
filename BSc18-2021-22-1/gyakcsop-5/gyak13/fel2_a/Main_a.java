

interface Reversable
{
    void reverse();
}

interface Printable
{
    void print();
}

class ReversablePoint implements Reversable
{
    private int x;
    private int y;
    private int prev_x, prev_y;

    public ReversablePoint(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.prev_x = x;
        this.prev_y = y;
    }

    public void setX(int x)
    {
        this.prev_x = this.x;
        this.x = x;
    }

    public void setY(int y)
    {
        this.prev_y = this.y;
        this.y = y;
    }

    @Override
    public void reverse()
    {
        this.x = this.prev_x;
        this.y = this.prev_y;
    }

    public String toString()
    {
        return "(" + x + "," + y + ")";
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

    @Override
    public void print()
    {
        System.out.print("(" + x + "," + y + ")" + System.lineSeparator());
    }
}

class Book implements Printable
{
    private String author, title;

    public Book(String author, String title)
    {
        this.author = author;
        this.title = title;
    }

    @Override
    public void print()
    {
        System.out.println(author + ", " + title);
    }
}

// nagyon fontos különbség az absztrakt osztályokhoz képest:
// egy osztály csak egy osztályból származhat le, de több interface-t is implementálhat
class PrintableAndReverseablePoint implements Printable, Reversable
{
    private int x;
    private int y;
    private int prev_x, prev_y;

    public PrintableAndReverseablePoint(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.prev_x = x;
        this.prev_y = y;
    }

    public void setX(int x)
    {
        this.prev_x = this.x;
        this.x = x;
    }

    public void setY(int y)
    {
        this.prev_y = this.y;
        this.y = y;
    }

    @Override
    public void reverse()
    {
        this.x = this.prev_x;
        this.y = this.prev_y;
    }

    @Override
    public void print()
    {
        System.out.print("(" + x + "," + y + ")" + System.lineSeparator());
    }

    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
}

class Main
{
    public static void foo(Printable something)
    {
        something.print();
    }

    public static void foo2(PrintableAndReverseablePoint something)
    {
        something.print();
        something.reverse();
    }

    public static void main(String[] args)
    {
        ReversablePoint rv = new ReversablePoint(2, 3);
        System.out.println(rv);
        rv.setX(10);
        System.out.println(rv);

        PrintablePoint pp = new PrintablePoint(2, 4);
        pp.print();

        Book book = new Book("a", "t");

        foo(book);
        foo(pp);
        //foo(rv);

        System.out.println("----------------------------------");
        PrintableAndReverseablePoint prp = new PrintableAndReverseablePoint(2, 3);
        prp.print();
        prp.setX(10);
        prp.print();
    }
}
