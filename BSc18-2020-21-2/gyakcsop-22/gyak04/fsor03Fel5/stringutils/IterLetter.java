

package stringutils;


public class IterLetter
{
    private String str;

    // felesleges; csak hangsúlyozom h a kezdőértéke 0
    // az adattagok 0-szerű értékre inicializálódnak, akkor is ha nem írjuk ki
    private int idx = 0;

    public IterLetter(String init_str)
    {
        str = init_str;
    }

    public void printNext()
    {
        System.out.println(str.charAt(idx++));

        //System.out.println(str.at(idx));
        //++idx;
    }

    public void restart()
    {
        idx = 0;
    }

    public boolean hasNext()
    {
        return idx != str.length();
        //return idx < str.length();
    }
}

