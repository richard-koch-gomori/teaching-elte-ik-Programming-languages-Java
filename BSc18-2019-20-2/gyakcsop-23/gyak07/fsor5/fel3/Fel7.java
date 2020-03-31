

class Fel7
{
    public static void main(String[] args)
    {
        try
        {
            if (args.length != 3)
            {
                System.out.println("Usage: Fel7 a m b");
                throw new IllegalArgumentException("Require 3 arguments");
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
            System.out.println("Invalid number, " + e.getMessage());
        }
        catch (ArithmeticException e)
        {
            System.out.println("Aritmetic error, " + e.getMessage());
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Invalid argument, " + e.getMessage());
        }
    }
}