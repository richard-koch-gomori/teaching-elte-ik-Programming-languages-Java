

class Fel4
{
    // args: a program argumentumai, az első argumentum a 0-adik indexű elem
    public static void main(String[] args)
    {
        if (args.length >= 1)
        {
            System.out.println("Hello " + args[0] + "!");
        }
        else
        {
            System.out.println("Please give me your name");
        }
    }
}
