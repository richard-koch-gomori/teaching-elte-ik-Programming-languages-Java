import java.util.Iterator;
import java.util.Collections;
import java.util.ArrayList;

class ExtendedString implements Iterable<Character>, Comparable<ExtendedString>
{
    private String data;

    public ExtendedString(String data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return data;
    }

    @Override
    public Iterator<Character> iterator()
    {
        return new ExtendedStringIterator(this.data);
    }

    @Override
    public int compareTo(ExtendedString that)
    {
        return this.data.length() - that.data.length();
    }
}

class ExtendedStringIterator implements Iterator<Character>
{
    private String stringToIterate;
    private int counter;

    public ExtendedStringIterator(String stringToIterate)
    {
        this.stringToIterate = stringToIterate;
        this.counter = 0;
    }

    @Override
    public boolean hasNext()
    {
        return counter < stringToIterate.length();
    }

    @Override
    public Character next()
    {
        return stringToIterate.charAt(counter++);
    }

    @Override
    public void remove()
    {
        ++counter;
    }
}

class Main
{
    public static void main(String[] args)
    {
        /*
        ExtendedString e1 = new ExtendedString("Java");
        Iterator<Character> it = e1.iterator();
        while (it.hasNext())
        {
            char ch = it.next();
            System.out.println(ch);
        }
        */
        ExtendedString temp1 = new ExtendedString("Java programming");
        ExtendedString temp2 = new ExtendedString("C++ programming");

        System.out.println("temp1.compareTo(temp2): " + temp1.compareTo(temp2));
        System.out.println("temp2.compareTo(temp1): " + temp2.compareTo(temp1));

        Iterator<Character> it = temp1.iterator();

        while (it.hasNext())
        {
            char ch = it.next();
            System.out.println("ch: " + ch);
        }

        System.out.println("-------------------------------------------------------");

        it = temp1.iterator();
        if (it.hasNext())
        {
            it.remove();
        }

        while (it.hasNext())
        {
            char ch = it.next();
            System.out.println("ch: " + ch);
        }

        ArrayList<ExtendedString> list = new ArrayList<ExtendedString>();
        list.add(new ExtendedString("This is a full sentence."));
        list.add(temp1);
        list.add(temp2);
        list.add(new ExtendedString("world"));
        list.add(new ExtendedString("hello"));
        list.add(new ExtendedString("java"));
        System.out.println(list);
        System.out.println();
        Collections.sort(list);
        System.out.println(list);
    }
}

/*
https://stackoverflow.com/questions/20639098/in-java-can-you-modify-a-list-while-iterating-through-it

https://stackoverflow.com/questions/17687536/is-it-safe-to-change-a-hashmap-key-value-during-iteration

Map<Long, Integer> map = new HashMap<Long, Integer>();
for (Long key : map.keySet() ) {
   int value = map.get(key);
   value--;
   map.put(key, value);
}

It is perfectly safe operation that you're doing since you're just changing value of an existing key in the Map.
However if you are ever going to delete an entry from Map then remeber to use Iterator.
*/


