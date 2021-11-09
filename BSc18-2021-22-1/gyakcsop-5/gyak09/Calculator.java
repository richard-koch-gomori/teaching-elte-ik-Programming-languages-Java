/*
Java-ban a kivételeknek 2 típusa van:

ELLENŐRZÖTT KIVÉTELEK
a compiler fordítási időben ellenőrzi, hogy a függvények szignatúráján a throws kulcsszó után
fel van sorolva, hogy a függvény milyen kivételeket dobhat, vagy a függvényen belül kezelve van
pl FileNotFoundException

NEM ELLENŐRZÖTT KIVÉTELEK
a fenti fordítási idejű ellenőrzést a compiler nem teszi meg
pl IllegalArgumentException, ArithmeticException, tömb kiindexelés
*/


class Calculator
{
    public static void main(String[] args)
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
}
