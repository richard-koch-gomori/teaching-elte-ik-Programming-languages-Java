

class Fel7
{
    public static void main(String[] args)
    {
        try
        {
            if (args.length != 3)
            {
                System.out.println("Usage: Fel7 a m b");

                // a kivétel konstruálásakor megadhatunk egy informáló üzenetet
                throw new IllegalArgumentException("Require at least 3 arguments");
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
            // az informáló üzenetet szerezhetjük meg a getMessage() metódussal
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