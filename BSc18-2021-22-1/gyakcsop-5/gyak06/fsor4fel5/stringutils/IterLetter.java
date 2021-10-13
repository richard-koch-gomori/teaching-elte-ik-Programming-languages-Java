

package stringutils; 

public class IterLetter
{
    private int index = 0; // azt jelenti, hogy hol tartunk az str sztringben
    private String str;

    public IterLetter(String init_str)
    {
        str = init_str;
    }

    public void printNext()
    {
        //if (index < str.length()) // index a sztringen belül van
        if (hasNext())
        {
            System.out.println(str.charAt(index)); // betűt
            index = index + 1; // index++;
        }
    }

    public void restart()
    {
        index = 0;
    }

    public boolean hasNext()
    {
        return index < str.length();
    }
}

