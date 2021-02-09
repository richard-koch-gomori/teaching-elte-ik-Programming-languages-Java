

class Fel3
{
    public static void main(String[] args)
    {
        /*
        System.out.print("Enter your name: ");
        String name;
        name = System.console().readLine();
        System.out.println("Hello " + name);
        */

        System.out.print("Enter your name: ");
        String name;
        name = System.console().readLine();
        System.console().printf("Hello %s%s", name, System.lineSeparator());
    }
}

