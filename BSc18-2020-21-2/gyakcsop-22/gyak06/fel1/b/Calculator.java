

class Calculator
{
    public static void main(String[] args)
    {
        try
        {
            if (args.length != 3)
            {
                throw new IllegalArgumentException();
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
                    throw new ArithmeticException();
                }
                System.out.println("div = " + (a / b));
            }
            else
            {
                throw new IllegalArgumentException();
            }
        }
        catch (NumberFormatException exc)
        {
            System.out.println("Invalid number format");
        }
        catch (IllegalArgumentException exc)
        {
            System.out.println("Invalid program arguments provided");
        }
        catch (ArithmeticException exc)
        {
            System.out.println("Arithmetic error");
        }
    }
}

