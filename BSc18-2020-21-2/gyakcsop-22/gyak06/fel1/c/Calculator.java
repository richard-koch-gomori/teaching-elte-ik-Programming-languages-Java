

class Calculator
{
    public static void main(String[] args)
    {
        try
        {
            if (args.length != 3)
            {
                // a kivétel konstruálásakor megadhatunk egy informáló üzenetet
                throw new IllegalArgumentException("Usage: java Calculator num1 op num2");
            }

            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[2]);
            char op = args[1].charAt(0);

            if (op == '+')
            {
                System.out.println("sum = " + (a + b));
            }
            else if (op == '-')
            {
                System.out.println("subtract = " + (a - b));
            }
            else if (op == '*')
            {
                System.out.println("product = " + (a * b));
            }
            else if (op == '/')
            {
                if (b == 0)
                {
                    throw new ArithmeticException("Divison by 0");
                }
                System.out.println("div = " + (a / b));
            }
            else
            {
                throw new IllegalArgumentException("Unknown operation");
            }
        }
        catch (NumberFormatException exc)
        {
            // az informáló üzenetet szerezhetjük meg a getMessage() metódussal
            System.out.println("Invalid number format: " + exc.getMessage());
        }
        catch (IllegalArgumentException exc)
        {
            System.out.println("Invalid program arguments provided: " + exc.getMessage());
        }
        catch (ArithmeticException exc)
        {
            System.out.println("Arithmetic error: " + exc.getMessage());
        }
    }
}

