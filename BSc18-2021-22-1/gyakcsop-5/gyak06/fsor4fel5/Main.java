// nincs package ; -> névtelen package

import stringutils.IterLetter;

class Main
{
    public static void main(String[] args)
    {
        /*IterLetter il = new IterLetter("süllyed a harossz");

        il.printNext(); // "s"
        il.printNext(); // "ü"
        // ...
        il.printNext(); // "z"
        il.printNext(); // ""

        il.restart();
        il.printNext(); // "s"*/

        for (IterLetter il = new IterLetter("süllyed a harossz"); il.hasNext(); il.printNext())
        {
            //printNext();
        }
    }
}

