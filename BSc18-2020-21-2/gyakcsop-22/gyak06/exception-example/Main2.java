

class Main2
{
    public static double calcSquareRoot(double num)
    {
        if (num < 0)
        {
            return -1; // hibakód
        }
        return Math.sqrt(num);
    }

    public static void main(String[] args)
    {
        System.out.print("Enter a num: ");
        String input = System.console().readLine();
        double d = Double.parseDouble(input);

        double res1 = calcSquareRoot(d);
        if (res1 == -1)
        {
            System.out.println("Error: negative num!");
            System.exit(1);
        }
        double res2 = 120 - 2*res1;
        double res3 = calcSquareRoot(res2);
        if (res3 == -1)
        {
            System.out.println("Error: negative num!");
            System.exit(1);
        }

        System.out.println("res3 = " + res3);
    }
}
