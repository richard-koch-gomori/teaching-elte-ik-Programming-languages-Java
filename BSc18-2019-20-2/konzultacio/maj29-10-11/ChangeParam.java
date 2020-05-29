

class ChangeParam
{
    public static void foo(int param)
    {
        param += 1;
    }

    public static void main(String[] args)
    {
        int x = 10;
        foo(x);
        System.out.println(x);
    }
}


