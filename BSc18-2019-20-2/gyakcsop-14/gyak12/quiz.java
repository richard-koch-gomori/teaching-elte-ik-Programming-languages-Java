/*
class Base
{
    void foo() { f(); }
    void f() { System.out.println("Base: f()"); }
}

class Derived extends Base
{
    void foo() { super.foo(); }
    void f() { System.out.println("Derived: f()"); }
}

class quiz
{
    public static void main(String[] args)
    {
        Base obj = new Derived();
        obj.foo();
    }
}
*/

/*
class Foo
{
    private int x;

    public Foo(int x)
    {
        this.x = x;
    }

    @Override
    public boolean equals(Object that)
    {
        System.out.println("Object arg");
        if (that instanceof Foo)
            return this.x == ((Foo)that).x;
        else
            return false;
    }

    public boolean equals(Foo that)
    {
        System.out.println("Foo arg");
        return this.x == that.x;
    }
}

class quiz
{
    public static void main(String[] args)
    {
        Foo foo1 = new Foo(10);
        Foo foo2 = new Foo(10);
        foo1.equals((Object)foo2);
// A (Object)foo2 kasztolás a foo2 statikus típusát nem változtatja meg,
// hanem a (Object)foo2 kifejezés eredményül egy olyan kifejezést ad,
// aminek a statikus típusa Object
// az Object-et fogadó equals hívódik meg, mert olyan argumentummal hívjuk,
// aminek a statikus típusa Object
    }
}
*/

/*
class Base
{
    public void print() { System.out.println("Base"); }
}

class Derived extends Base
{
    public void print() { System.out.println("Derived"); }
}

class quiz
{
    public static void main(String[] args)
    {
        Derived obj = new Derived();
        ((Base)obj).print();
// továbbra is a dinamikus típus alapján dönti el a rendszer, hogy melyik print()
// metódus hívódik meg, a statikus típus ezt nem befolyásolja
    }
}
*/

/*
class Base
{
    public int i = 1;
}

class Derived extends Base
{
    public int i = 2;
    
    public void foo()
    {
        System.out.println("i = " + super.i);
    }
}

class quiz
{
    public static void main(String[] args)
    {
        Base obj = new Derived();
        System.out.println(obj.i); // adattagokat nem override-olhatunk

// Stackoverflow:
// When you make a variable of the same name in a subclass, that's called hiding.
// The resulting subclass will now actually have both properties.
// You can access the one from the superclass with super.var or ((SuperClass)this).var.
// The variables don't even have to be of the same type; they are just two variables
// sharing a name, much like two overloaded methods.
// https://stackoverflow.com/questions/10722110/overriding-member-variables-in-java-variable-hiding

        new Derived().foo();
    }
}
*/

/*
class Base
{
    protected int i = 1;
    public int f() { return i; }
}

class Derived extends Base
{
    protected int i = 2;
    public int f() { return i; }
}

class quiz
{
    public static void main(String[] args)
    {
        Base obj = new Derived();
        System.out.println(obj.f());
    }
}
*/


class Base
{ 
    static int value() { return 0; } 
    static void print() { System.out.println(value()); } 
}

class Sub extends Base
{
    static int value() { return 1; } // statikus metódusokat nem lehet override-olni
    //static void print() { System.out.println(value()); }
}

class quiz
{
    public static void main(String[] args)
    {
        Sub.print();
    }
}


/*
class Base
{ 
    int value() { return 0; } 
    void print() { System.out.println(value()); } 
}

class Sub extends Base
{
    int value() { return 1; }
}

class quiz
{
    public static void main(String[] args)
    {
        new Sub().print();
    }
}
*/

/*
class quiz
{
    public static void main(String[] args)
    {
        Integer i = 3;
        ++i;
        System.out.println(i);
    }
}
*/

