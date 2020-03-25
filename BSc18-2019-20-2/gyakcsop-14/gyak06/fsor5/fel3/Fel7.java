
class Fel7
{
    public static void main(String[] args)
    {
        try
        {
            if (args.length != 3)
            {
                // a konstruáláskor egy konkrét, informáló üzenetet megadhatunk
                throw new IllegalArgumentException("Provide 3 arguments");
            }
            double a = Double.parseDouble(args[0]);
            char m = args[1].charAt(0);
            double b = Double.parseDouble(args[2]);

            switch (m)
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
                        throw new ArithmeticException("Division by zero");
                    }
                    System.out.println("a / b = " + (a / b));
                    break;
                }
                case '%':
                {
                    if (b == 0)
                    {
                        throw new ArithmeticException("Division by zero");
                    }
                    System.out.println("a % b = " + (a % b));
                    break;
                }
                default:
                {
                    throw new IllegalArgumentException("Unknown operation");
                }
            }
        }
        catch (NumberFormatException e)
        {
            // getMessage()-vel tudjuk lekérdezni mi volt a konstruáláskor megadott üzenet
            System.out.println("Error: invalid format, " + e.getMessage());
        }
        catch (ArithmeticException e)
        {
            System.out.println("Error: arithmetic error, " + e.getMessage());
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Error: invalid arg, " + e.getMessage());
        }
    }
}
