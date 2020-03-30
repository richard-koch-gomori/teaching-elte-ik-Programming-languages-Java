

class Main
{
    public static void main(String[] args)
    {
        new Foo();
    }
}

class Foo
{
    private int x = 10;
    private static int y = 20;

    public Foo()
    {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}

