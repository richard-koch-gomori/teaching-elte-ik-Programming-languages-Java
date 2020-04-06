

import stringutils.IterWord;


public class Main {
    public static void main(String[] args) {
        IterWord it = new IterWord("This is a sentence.");

        it.printNext();
        it.printNext();

        it.restart();
        while (it.hasNext()) {
            it.printNext();
        }
    }
}

