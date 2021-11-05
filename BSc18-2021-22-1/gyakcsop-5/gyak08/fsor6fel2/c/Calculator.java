class Calculator
{
    public static void main(String[] args)
    {
        try
        {
            if (args.length != 3)
            {
                // a kivétel konstruálásakor megadhatunk egy informáló üzenetet
                throw new IllegalArgumentException("Invalid usage");
            }
            double a = Double.parseDouble(args[0]);
            char op = args[1].charAt(0);
            double b = Double.parseDouble(args[2]);

            switch (op)
            {
                case '+':
                {
                    System.out.println("a + b = " + (a + b));
                    break;
                }
                case '-':
                {
                    System.out.println("a - b = " + (a - b));
                    break;
                }
                case '*':
                {
                    System.out.println("a * b = " + (a * b));
                    break;
                }
                case '/':
                {
                    if (b == 0)
                    {
                        throw new ArithmeticException("div. by zero");
                    }
                    System.out.println("a / b = " + (a / b));
                    break;
                }
                default:
                {
                    throw new IllegalArgumentException("unsupported operator");
                }
            }
        }
        catch (NumberFormatException exc)
        {
            // az informáló üzenetet szerezhetjük meg a getMessage() metódussal
            System.out.println("Conversion error occured: " + exc.getMessage());
        }
        catch (IllegalArgumentException exc)
        {
            System.out.println("Argumentum error: " + exc.getMessage());
        }
        catch (ArithmeticException exc)
        {
            System.out.println("Arithmetic error: " + exc.getMessage());
        }
    }
}
