

class Calculator
{
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Usage: java Calculator num1 num2");
            System.exit(1);
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        // a + b, a - b, a * b

        System.out.println("sum = " + (a + b));
        System.out.println("subtract = " + (a - b));
        System.out.println("product = " + (a * b));

        if (b != 0)
        {
            System.out.println("div = " + ((double)a / b));
            System.out.println("mod = " + (a % b));
        }
    }
}
