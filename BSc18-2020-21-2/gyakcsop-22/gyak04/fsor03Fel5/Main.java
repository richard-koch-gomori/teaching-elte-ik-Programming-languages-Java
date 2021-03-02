
import stringutils.IterLetter;


public class Main
{
    public static void main(String[] args)
    {
        /*
        IterLetter it = new IterLetter("Süllyed a harossz!");
        it.printNext(); // S
        it.printNext(); // ü
        it.printNext(); // l

        it.printNext();
        it.printNext();
        it.printNext();
        it.printNext();
        it.printNext();
        it.printNext();
        it.printNext();
        it.printNext();
        it.printNext();
        it.printNext();
        it.printNext();
        it.restart();
        it.printNext(); // S
        it.printNext();
        it.printNext();
        it.printNext();
        it.printNext();
        it.printNext();
        it.printNext();
        */

        for (IterLetter it = new IterLetter("Süllyed a harossz!"); it.hasNext(); )
        {
            it.printNext();
        }
    }
}

