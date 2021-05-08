// Peszleg Márton megoldása

import java.util.HashMap;

public class Fsor09fel4
{
    public static void main(String[] args) 
    {
        /*HashMap<String,Integer>m = new HashMap<>();
        m.put("Zalan", 20);
        m.put("Ricsi", 25);
        m.put("Marton", 19);
        System.out.println(m.get("Gergő"));*/

        MultiSet set1 = new MultiSet();
        set1.put("java");
        set1.put("java");
        set1.put("javascript");
        set1.put("c++");
        System.out.println("set1 = " + set1.getData());


        MultiSet set2 = new MultiSet();
        set2.put("java");
        set2.put("python");
        set2.put("python");
        set2.put("c++");
        set2.put("java");
        set2.put("c++");
        set2.put("bash");
        System.out.println("set2 = " + set2.getData());

        HashMap<String,Integer> data = set2.getData();
        data.put("powershell", 30);
        System.out.println("set2 = " + set2.getData());

        MultiSet res = set1.intersect(set2);
        System.out.println("res = "+res.getData());
    }
}

class MultiSet
{
    private HashMap<String,Integer>m;

    public MultiSet()
    {
        m = new HashMap<>();
    }

    public MultiSet(HashMap<String,Integer> init)
    {
        m = new HashMap<>(init);
    }

    public HashMap<String,Integer> getData()
    {
        return new HashMap<>(m);
    }

    public void put(String s)
    {
        if(m.containsKey(s))
        {
            int var = m.get(s);
            m.replace(s, var+1);
        }
        else m.put(s, 1);
    }

    public MultiSet intersect(MultiSet other)
    {
        HashMap<String,Integer> result = new HashMap<>();

        for(String key : m.keySet())
        {
            if(other.m.containsKey(key))
            {
                int min = Math.min(m.get(key),other.m.get(key));
                result.put(key,min);
            }
        }

        return new MultiSet(result);
    }
}


