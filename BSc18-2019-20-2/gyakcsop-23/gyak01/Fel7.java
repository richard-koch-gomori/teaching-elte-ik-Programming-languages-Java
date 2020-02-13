

class Fel7
{
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            System.out.println("Usage: Fel7 a b");

            // exit(0) leállítja a programot 0-ás exitkóddal
            System.exit(0);
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        if (b != 0)
        {
            // a és b is egész szám
            // az egyiket double--é konvertáljuk, hogy lebegőpontos osztás történjen
            System.out.println("a / b = " + ((double)a / b));
            System.out.println("a % b = " + (a % b));
        }
    }
}