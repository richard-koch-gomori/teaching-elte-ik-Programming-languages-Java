

class Main5
{
    public static double calcSquareRoot(double num)
    {
        if (num < 0)
        {
            throw new IllegalArgumentException();
        }
        return Math.sqrt(num);
    }

    public static void foo()
    {
        System.out.print("Enter a num: ");
        String input = System.console().readLine();
        double d = Double.parseDouble(input);

        double res1 = calcSquareRoot(d);
        double res2 = 120 - 2*res1;
        double res3 = calcSquareRoot(res2);

        System.out.println("res3 = " + res3);
    }

    public static void main(String[] args)
    {
        foo(); // ha a main() sem kapja el, akkor a JVM fogja elkapni, és kiírja a stack trace-t
    }
}

/*
stack trace:
ha egy kivétel miatt leáll a program, akkor a JVM listázza a keletkezett kivétel helyét
és hozzá vezető hívási láncot
*/