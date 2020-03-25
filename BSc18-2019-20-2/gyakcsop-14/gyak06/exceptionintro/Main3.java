

class Main3
{
    public static double calcSquareRoot(double num)
    {
        if (num < 0)
        {
            // hagyjuk a hibakódok visszatérési értékként való jelzését
            // calcSquareRoot() dob egy IllegalArgumentException kivételt
            throw new IllegalArgumentException();

            // ennek hatására a calcSquareRoot() fv végrehajtása megszakad
            // a vezérlés a hívási láncon visszafelé haladva az első catch (IllegalArgumentException e) {} handler-hez kerül
        }
        return Math.sqrt(num);
    }

    public static void main(String[] args)
    {
        System.out.print("Enter a num: ");
        String input = System.console().readLine();
        double d = Double.parseDouble(input);

        double res3 = 0;
        // védett kód (ami kivételt dobhat) try{} blokkba szervezése
        try
        {
            double res1 = calcSquareRoot(d); // ha kivétel keletkezik, a következő sor már nem kerül végrehajtásra
            double res2 = 120 - 2*res1;
            res3 = calcSquareRoot(res2);
        }
        // több catch handler esetén a vezérlés a keletkezett kivételnek megfelelő handler-hez kerül
        catch (IllegalArgumentException e)
        {
            System.out.println("Error: negative num!");
            System.exit(1);
        }

        System.out.println("res3 = " + res3);
    }
}
