

class Main2
{
    // visszatérési érték:
    // -1 esetén hiba történt
    // máskülönben ok
    public static double calcSquareRoot(double num)
    {
        if (num < 0)
        {
            // a -1 egy jó hibajelző visszatérési érték, mert ha valós számból valós
            // négyzetgyököt vonunk, akkor 0 vagy pozitív számot kapunk
            // ha tehát a hívó ellenőrzi a visszatérési értéket, és -1 értéket kap,
            // akkor megállapítja, hogy hiba történt
            // több hiba esetén -2, -3, ...
            // ezen lehet javítani azzal h szimbolikus állandókat vezetünk be az egyes hibakódokra
            return -1;
        }
        return Math.sqrt(num);
    }

    public static void main(String[] args)
    {
        System.out.print("Enter a num: ");
        String input = System.console().readLine();
        double d = Double.parseDouble(input);

        double res1 = calcSquareRoot(d);
        // ha hiba történt, kezeli a hibát: kiírja h "Error: negative num!", és leállítja a programot
        // általában nem feltétlenül leállítja a programot, bekérhet új inputot és azzal dolgozik tovább etc . . .
        if (res1 == -1)
        {
            System.out.println("Error: negative num!");
            System.exit(1);
        }
        double res2 = 120 - 2*res1;
        double res3 = calcSquareRoot(res2);
        // ugyanaz a hibakezelő kód redundánsan ismétlődik a kódban
        if (res3 == -1)
        {
            System.out.println("Error: negative num!");
            System.exit(1);
        }

        // ez annyiból jobb, h itt tudom h a res3 valid, de a kód tele van szemetelve hibakezeléssel
        // a lényegi számítás "elveszik" a sok hibakezelő kódban
        System.out.println("res3 = " + res3);
    }
}
