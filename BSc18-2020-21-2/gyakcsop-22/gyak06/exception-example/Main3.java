

class Main3
{
    public static double calcSquareRoot(double num)
    {
        if (num < 0)
        {
            throw new IllegalArgumentException();
        }
        return Math.sqrt(num);
    }

    public static void main(String[] args)
    {
        System.out.print("Enter a num: ");
        String input = System.console().readLine();
        double d = Double.parseDouble(input);

        double res3 = 0;
        try
        {
            double res1 = calcSquareRoot(d);
            double res2 = 120 - 2*res1;
            res3 = calcSquareRoot(res2);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Error: negative num!");
            System.exit(1);
        }

        System.out.println("res3 = " + res3);
    }
}
