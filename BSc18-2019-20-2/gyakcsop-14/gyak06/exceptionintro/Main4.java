

class Main4
{
    public static double calcSquareRoot(double num)
    {
        if (num < 0)
        {
            throw new IllegalArgumentException();
        }
        return Math.sqrt(num);
    }

    public static void foo()
    {
        System.out.print("Enter a num: ");
        String input = System.console().readLine();
        double d = Double.parseDouble(input);

        double res1 = calcSquareRoot(d);
        double res2 = 120 - 2*res1;
        double res3 = calcSquareRoot(res2);

        System.out.println("res3 = " + res3);
    }

    public static void main(String[] args)
    {
        try
        {
            foo();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Error: negative num!");
            System.exit(1);
        }
    }
}