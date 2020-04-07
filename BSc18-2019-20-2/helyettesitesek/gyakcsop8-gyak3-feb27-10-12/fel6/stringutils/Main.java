
// órán nem vettük figyelembe, hogy a Main névtelen csomagba kerüljön
// névtelen csomag: nincs package csomagnév;

package stringutils;


public class Main
{
    public static void main(String[] args)
    {
        IterLetter it = new IterLetter("HelloWorld");
        it.printNext(); // 'H'
        it.printNext(); // 'e'

        it.restart();
        it.printNext(); // 'H'

        while (it.hasNext())
        {
            it.printNext();
        }
    }
}

