// compile: javadoc JavadocEx.java

/**
 * @author author_name
 * @since 1.0
 * @version 1.0
 */
public class JavadocEx {
    /**
     *  The starting point of the Java application.
     * @param args commandline arguments
     */
    public static void main(String[] args) {
        try {
            //String[] example = {"50", "-", "51.2"};
            //System.out.println(calculateFromArgs(example, -2)); //50 - 51.2 //true

            System.out.println(calculateFromArgs(args, -2));
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println("Invalid program arguments provided.");
            System.out.println(e.getMessage());
        }
        catch (ArithmeticException e) {
            System.out.println("Arithmetic error occured.");
            System.out.println(e.getMessage());
        }
    }

    /**
     * <p>Performs the mathematical operation denoted by the third element of the args array on the first
     * and second element and returns {@code true} if the result of the calculation rounded down to its nearest
     * neighbouring integer is equal to the second method parameter or {@code false} otherwise.</p>
     * @param args array of arguments
     * @param result awaited result after the operation is performed
     * @throws IllegalArgumentException if there aren't exactly 3 arguments provided
     * @throws ArithmeticException if there is an attempt of dividing by zero
     * @return the logical boolean value of the equity check between the input and the desired result
     * @since 1.0
     */
    public static boolean calculateFromArgs(String[] args, double result) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Not exactly three arguments provided.");
        } else {
            double a = Double.parseDouble(args[0]);
            char m = args[1].charAt(0);
            double b = Double.parseDouble(args[2]);
            switch (m) {
                case '+':
                    return result == Math.floor(a + b);
                case '-':
                    return result == Math.floor(a - b);
                case '*':
                    return result == Math.floor(a * b);
                case '/':
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    return result == Math.floor(a / b);
                default:
                    throw new IllegalArgumentException("Unknown operation");
            }
        }
    }
}
