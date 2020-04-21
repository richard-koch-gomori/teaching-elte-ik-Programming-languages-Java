//Készítette: Lukács Dávid István
package a;
import java.lang.StringBuilder;
import java.util.Arrays;
public class IntList
{
    private int  aktmeret,maxmeret;
    private int[] values;

    public IntList(int maxm)
    {
        this.maxmeret=maxm;
        aktmeret=0;
        values = new int[maxm];
    }

    public void add(int e)
    {
        values[aktmeret++]=e;
    }

    public void concat(IntList that)
    {
        if(this.aktmeret+that.aktmeret<=this.maxmeret)
        {
            for(int idx=0;idx<that.aktmeret;idx++)
            {
                this.values[aktmeret++]=that.values[idx];
            }
        }
        else throw new IllegalStateException();
    }

    public String toString()
    {
        if(aktmeret==0) return "empty";

        StringBuilder sb= new StringBuilder();
        for(int idx=0; idx<this.aktmeret;idx++)
        {
            sb.append(values[idx]);
            if(idx==aktmeret-1)break;
            sb.append(",");
        }
        return sb.toString();
    }


    public void removeItemsGreaterThan(int limit)
    {
        Arrays.sort(this.values);
        for(int idx=0; idx<aktmeret; idx++)
        {
            if(values[idx]>=limit)
            {
                aktmeret=idx;
                break;
            }
        }
    }
}