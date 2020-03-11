


class Foo
{
    private int var;
    private static int counter = 0;

    public Foo(int var)
    {
        this.var = var;
    }

    public void method()
    {
        counter++;
        System.out.println("var = " + var);
        System.out.println("counter = " + counter);
    }
}

class Main
{
    public static void main(String[] args)
    {
        Foo f = new Foo(20);
        f.method(); // 1

        Foo f2 = new Foo(120);
        f2.method(); // 2
        f2.method(); // 3
        f2.method(); // 4
    }
}




