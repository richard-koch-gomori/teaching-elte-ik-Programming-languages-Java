
import java.util.HashMap;
import java.util.Set;

// 2 típusa van
// - ellenőrzött: Exception
// - nem ellenőrzött: RuntimeException / Error

class MyCustomException extends Exception
{
    public MyCustomException()
    {
    }

    public MyCustomException(String errorMessage)
    {
        super(errorMessage);
    }
}

class Foo<T>
{
    private T foo;

    public Foo(T data)
    {
        foo = data;
        System.out.println(foo);
    }
}

class Main
{
    public static void foo(int i) throws MyCustomException
    {
        // ...
        if (i < 0)
        {
            throw new MyCustomException("error");
        }
        // ...
    }

    public static void main(String[] args)
    {
        /*
        HashMap<String, String> m = new HashMap<String, String>();
        m.put("key1", "value1");
        m.put("key2", "...");
        m.put("Micimackó", "Makacka");
        System.out.println(m.get("key1"));
        System.out.println(m);

        System.out.println("m.keySet = ");
        for (String key : m.keySet())
        {
            System.out.println(key);
        }

        Set<String> set = m.keySet();
        m.put("alma", "alma2");
        System.out.println("set = ");
        for (String key : set)
        {
            System.out.println(key);
        }


        try
        {
            foo(-1);
        }
        catch (MyCustomException exc)
        {
            System.out.println(exc.getMessage());
        }*/

        Foo<Integer> foo = new Foo<>(45);
        Foo<String> foo2 = new Foo<>("foo");
    }
}

