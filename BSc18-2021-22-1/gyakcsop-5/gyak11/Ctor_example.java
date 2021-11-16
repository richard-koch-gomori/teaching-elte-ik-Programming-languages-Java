
class Foo
{
    private int x;

    public Foo() {}

    public Foo(int x)
    {
        this.x = x;
    }

    public void print() { System.out.println("x = " + x); }
}

class Main
{
    public static void main(String[] args)
    {
        Foo foo = new Foo();
        foo.print();
    }
}

