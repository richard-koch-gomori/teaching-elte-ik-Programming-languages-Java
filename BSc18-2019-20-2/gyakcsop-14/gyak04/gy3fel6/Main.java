

import stringutils.*;

public class Main
{
    public static void main(String[] args)
    {
        IterLetter it = new IterLetter("Hello world");
        it.printNext(); // 'H'
        it.printNext(); // 'e'

        it.restart();
        it.printNext(); // 'H'
        it.hasNext();

        it.restart();
        while (it.hasNext())
        {
            it.printNext();
        }

        //String str = "abc";
        //System.out.println(str.charAt(4)); // nyilván értelmetlen, excpetion-nel leáll a program
    }
}
