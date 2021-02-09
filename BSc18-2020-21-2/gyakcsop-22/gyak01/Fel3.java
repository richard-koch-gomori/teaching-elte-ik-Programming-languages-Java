// fordítás: javac Fel3.java
// futtatás: java Fel3


class Fel3
{
    public static void main(String[] args)
    {
        /*
        System.out.print("Enter your name: ");
        String name;
        name = System.console().readLine();

        // String-eket lehet összefűzni a + művelettel
        System.out.println("Hello " + name);
        */

        // kiírás a képernyőre
        System.out.print("Enter your name: ");
        String name;

        // System.console().readLine() beolvas a billentyűzetről, sztringgel tér vissza
        // beépített sztring típus: String
        name = System.console().readLine();
        System.console().printf("Hello %s%s", name, System.lineSeparator());
    }
}

