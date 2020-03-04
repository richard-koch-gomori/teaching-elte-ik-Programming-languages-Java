

import stringutils.IterLetter;


class Main
{
    public static void main(String[] args)
    {
        IterLetter it = new IterLetter("Hello world");

        it.printNext(); // 'H'
        it.printNext(); // 'e'

        it.restart();
        it.printNext(); // 'H'

        it.restart();
        while (it.hasNext())
        {
            it.printNext();
        }
    }
}

