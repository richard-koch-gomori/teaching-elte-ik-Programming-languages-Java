

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
    private int x;
    private int y;

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

    public String toString()
    {
        return "(" + x + "," + y + ")";
    }
}


class ReversablePoint extends Point implements Reversable
{
    private int prev_x, prev_y;

    public ReversablePoint(int x, int y)
    {
        super(x, y);
        this.prev_x = x;
        this.prev_y = y;
    }

    public void setX(int x)
    {
        this.prev_x = super.getX();
        super.setX(x);
    }

    public void setY(int y)
    {
        this.prev_y = super.getY();
        super.setY(y);
    }

    @Override
    public void reverse()
    {
        super.setX(this.prev_x);
        super.setY(this.prev_y);
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
        System.out.println("(" + super.getX() + "," + super.getY() + ")");
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

class PrintableAndReverseablePoint extends Point implements Printable, Reversable
{
    private int prev_x, prev_y;

    public PrintableAndReverseablePoint(int x, int y)
    {
        super(x, y);
        this.prev_x = x;
        this.prev_y = y;
    }

    public void setX(int x)
    {
        this.prev_x = super.getX();
        super.setX(x);
    }

    public void setY(int y)
    {
        this.prev_y = super.getY();
        super.setY(y);
    }

    @Override
    public void reverse()
    {
        super.setX(this.prev_x);
        super.setY(this.prev_y);
    }

    @Override
    public void print()
    {
        System.out.print("(" + super.getX() + "," + super.getY() + ")" + System.lineSeparator());
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