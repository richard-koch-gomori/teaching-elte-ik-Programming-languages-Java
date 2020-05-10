

class Main
{
    public static void main(String[] args)
    {
        try
        {
            IntList list = new IntList(2);
            list.add(2);
            list.add(3);
            //list.add(4);
            System.out.println("list: " + list);

            IntList list2 = new IntList(5);
            list2.add(7);
            list2.add(10);
            list2.add(6);
            list2.concat(list);
            System.out.println("list2: " + list2);
            list2.removeItemsGreaterThan(7);
            System.out.println("filtered list2: " + list2);
        }
        catch (IllegalStateException e)
        {
            System.out.println("Error: IntList container is full");
        }
    }
}


