

import java.util.Arrays;
import java.util.LinkedList;


class IntList
{
    private LinkedList<Integer> data;

    public IntList()
    {
        data = new LinkedList<Integer>();
    }

    public IntList(Integer[] array)
    {
        data = new LinkedList<Integer>();
        data.addAll(Arrays.asList(array));
    }

    public void add(int item)
    {
        data.add(item);
    }

    public void concat(IntList that)
    {
        data.addAll(that.data);
    }

    public String toString()
    {
        if (data.size() > 0)
        {
            return data.toString();
        }
        else
        {
            return "empty";
        }
    }

    public void removeItemsGreaterThan(int limit)
    {
        data.removeIf(num -> (num > limit));
    }
}



