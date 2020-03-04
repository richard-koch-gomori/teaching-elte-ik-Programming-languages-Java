

package stringutils;


public class IterLetter
{
    private String str;
    private int counter;

    public IterLetter(String str)
    {
        // this: annak az objektumnak a referenciája, amin a metódust meghívták
        this.str = str;

        // felesleges; csak hangsúlyozom h a kezdőértéke 0
        // az adattagok 0-szerű értékre inicializálódnak, akkor is ha nem írjuk ki
        counter = 0;
    }
    public void printNext()
    {
        if (hasNext()) // this.hasNext()
        {
            System.out.println(str.charAt(counter));
            ++counter;
        }
    }
    public void restart()
    {
        counter = 0;
    }
    public boolean hasNext()
    {
        return counter < str.length();
    }
}

