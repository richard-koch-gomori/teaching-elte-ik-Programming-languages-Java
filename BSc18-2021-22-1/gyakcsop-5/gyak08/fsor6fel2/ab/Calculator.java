class Calculator
{
    // java Calculator 1 + 2
    // args[0] == "1"
    // args[1] == "+"
    // args[2] == "2"
    public static void main(String[] args)
    {
        try
        {
            //System.out.println("length = " + args.length);
            if (args.length != 3)
            {
                throw new IllegalArgumentException();
            }
            double a = Double.parseDouble(args[0]);
            //System.out.println("a = " + a + ", args[0] = " + args[0]);
            char op = args[1].charAt(0);
            // op == '+'
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
                        throw new ArithmeticException();
                    }
                    System.out.println("a / b = " + (a / b));
                    break;
                }
                default:
                {
                    throw new IllegalArgumentException();
                }
            }
        }
        // handler == kivételkezelő ág
        // néhány fontosabb kivétel kezelése, általános jellegű hibaüzenet kiírása
        catch (NumberFormatException exc)
        {
            System.out.println("Invalid number");
        }
        catch (IllegalArgumentException exc)
        {
            System.out.println("Usage: java Calculator num1 op num2");
        }
        catch (ArithmeticException exc)
        {
            System.out.println("div. by zero");
        }
    }
}
