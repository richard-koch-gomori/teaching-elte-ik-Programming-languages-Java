// Gál Gergely megoldása

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

class Main
{
    public static void minToFront(ArrayList<Integer> Nums)
    {
        if(Nums.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        Integer tmp=Collections.min(Nums);
        Nums.remove(tmp);
        Nums.add(0, tmp);
    }

    public static void main(String[] args) 
    {
        ArrayList<Integer> Nums = new ArrayList<Integer>();
        Nums.addAll(Arrays.asList(4, 65, 45, 44, 76, 2, 98, 72));
        minToFront(Nums);
        System.out.println(Nums);
    }
}


