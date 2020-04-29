// hiányos megoldás, ld. következő gyakorlat

//import java.util.HashMap;

class Main
{
    public static void main(String[] args)
    {
        Bag<String> bag1 = new Bag<String>();
        bag1.add("alma");
        bag1.add("alma");
        bag1.add("korte");
        System.out.println(bag1); // alma-2, korte-1
        System.out.println(bag1.countOf("dmat"));
        System.out.println(bag1.countOf("alma"));
        try
        {
            bag1.remove("almaa");
        }
        catch (NotInBagException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(bag1); // korte-1

        /*
        HashMap<String, Integer> obj = new HashMap<String, Integer>();
        obj.put("alma", 2);
        obj.put("dimat", 10);
        System.out.println(obj.get("alma"));
        System.out.println(obj.containsKey("dimat"));
        System.out.println(obj);
        obj.remove("dimat");
        System.out.println(obj);
        */
    }
}
