### 1. kérdés

Mit ír ki?

~~~{.java}
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
~~~

- Base: f()
- [helyes] Derived: f()

### 2. kérdés

Melyik `equals()` hívódik meg?

~~~{.java}
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
    }
}
~~~

- [helyes] `equals(Object)`
- `equals(Foo)`

### 3. kérdés

Mit ír ki?

~~~{.java}
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
    }
}
~~~

- Base
- [helyes] Derived

### 4. kérdés

Mit ír ki?

~~~{.java}
class Base
{
    public int i = 1;
}

class Derived extends Base
{
    public int i = 2;
}

class quiz
{
    public static void main(String[] args)
    {
        Base obj = new Derived();
        System.out.println(obj.i);
    }
}
~~~

- [helyes] 1
- 2

### 5. kérdés

Mit ír ki?

~~~{.java}
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
~~~

- 1
- [helyes] 2

### 6. kérdés

Mit ír ki a `Sub.print()` hívás?

~~~{.java}
class Base
{ 
    static int value() { return 0; } 
    static void print() { System.out.println(value()); } 
}

class Sub extends Base
{
    static int value() { return 1; }
}
~~~

- [helyes] 0
- 1
- 01
- Fordítási hiba, nem hívható meg a `print()` a `Sub` osztályon

### 7. kérdés

Mit ír ki a `new Sub().print()` hívás?

~~~{.java}
class Base
{ 
    int value() { return 0; } 
    void print() { System.out.println(value()); } 
}

class Sub extends Base
{
    int value() { return 1; }
}
~~~

- 0
- [helyes] 1
- 01
- Fordítási hiba, nem hívható meg a `print()` a `Sub` osztályon

### 8. kérdés

Rajzoljon memóriatérképet a következő programhoz.

~~~{.java}
class quiz
{
    public static void main(String[] args)
    {
        Integer i = 3;
        ++i;
        System.out.println(i);
    }
}
~~~

```
			stack			heap

[Integer i = 3;] 				Integer(3)
[++i]			i --------------------- Integer(4)
```


