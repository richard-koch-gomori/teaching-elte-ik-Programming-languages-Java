// Készítette: Lukács Dávid István
package c;
import b.IntList;

public class NamedIntList extends IntList
{
    private String name;
    public NamedIntList(int[] importvalues,String n)
    {
        super(importvalues);
        name=n;
    }

    public String toString()
    {
        StringBuilder sb= new StringBuilder();
        sb.append("name: ").append(name).append(" values: ");
        sb.append(super.toString());
        return sb.toString();
    }
}