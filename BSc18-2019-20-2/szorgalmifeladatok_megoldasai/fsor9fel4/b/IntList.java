// Készítette: Lukács Dávid István

/* 
A jelentős különbség, hogy az ArrayList(vagy LinkedList) használatával olyan metódusokhoz jutunk hozzá,
amelynek köszönhetően az "a" megoldásban használt maxmeret és az aktmeret adattagok elhagyhatóak, és például a concat és a removeItemsGreaterThan megoldása
is jelentősen lerövidül az elérhető előre definiált metódusok miatt.
*/
package b;
import java.lang.StringBuilder;
import java.util.ArrayList;

public class IntList
{
    private ArrayList<Integer> values;

    public IntList()
    {
        values = new ArrayList<Integer>();
    }

    public IntList(int[] importvalues)
    {
        values = new ArrayList<Integer>();
        for(int idx=0; idx<importvalues.length; idx++)
        {
            values.add(importvalues[idx]);
        }
    }

    public void add(Integer e)
    {
        values.add(e);
    }

    public void concat(ArrayList<Integer> that)
    {
       values.addAll(that);
    }

    public String toString()
    {
       // if(values.isEmpty())return "empty";
        
        StringBuilder sb= new StringBuilder();
        for(int idx=0; idx<values.size();idx++)
        {
            sb.append(values.get(idx));
            if(idx==values.size()-1)break;
            sb.append(",");
        }
        return sb.toString();

    }

    public void removeItemsGreaterThan(int limit)
    {
        values.removeIf(num -> (num > limit));
    }

}