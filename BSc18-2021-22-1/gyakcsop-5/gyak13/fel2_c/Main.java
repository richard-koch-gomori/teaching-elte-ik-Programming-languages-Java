

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