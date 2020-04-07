

package stringutils;


public class IterLetter
{
    private String str;
    private int counter;

    public IterLetter(String str)
    {
        this.str = str;
        this.counter = 0;
    }

    public void printNext()
    {
        if (hasNext())
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

