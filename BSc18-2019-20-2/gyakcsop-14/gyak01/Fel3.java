// fordítás: javac Fel3.java
// futtatás: java Fel3


class Fel3
{
    public static void main(String[] args)
    {
        // kiírás a képernyőre
        System.out.print("Enter name: ");

        // System.console().readLine() beolvas a billentyűzetről, sztringgel tér vissza
        // beépített sztring típus: String
        String name = System.console().readLine();

        // String-eket lehet összefűzni a + művelettel
        System.out.println("Hello " + name);
    }
}

