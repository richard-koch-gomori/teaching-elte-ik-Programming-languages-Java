import java.util.HashMap;

class Main
{
    public static void main(String[] args)
    {
        Bag<String> bag1 = new Bag<String>();
        bag1.add("alma");
        bag1.add("alma");
        bag1.add("dimat");
        System.out.println(bag1); // alma-2, dimat-1

        /*
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("alma", 5);
        map.put("dimat", 1);
        System.out.println(map);
        System.out.println(map.containsKey("dimat2"));
        System.out.println(map.get("dimat"));
        */
    }
}