

// öröklődés funkciói:
// - kódöröklés: a leszármazott osztályban is szükség van korábban megírt adattagokra, metódusokra
// - ld. köv. gyakorlat

// alaposztály, ősosztály
class Book
{
    private String author, title;
    protected int pages; // Book és a Book-ból származó osztályok férhetnek hozzá

    public Book()
    {
        this.author = "John Steinbeck";
        this.title = "Of mice and men";
        this.pages = 107;
    }

    public Book(String author, String title, int pages)
    {
        if (author == null || title == null || author.length() < 2 || title.length() < 4)
        {
            throw new IllegalArgumentException();
        }

        this.author = author;
        this.title = title;
        this.pages = pages;
    }

    public String getShortName()
    {
        return author.substring(0, 2) + ": " + title.substring(0, 4) + ", pages: " + pages;
    }
}

// leszármazmazott, gyermek
// a konstruktorok nem öröklődnek
// a privát adattagok és függvények öröklődnek, csak nem lehet rájük közvetlenül hivatkozni
// (vmilyen setter-en/getter-en keresztül viszont elérhetőek)
class PrintedBook extends Book
{

}

class EBook extends Book
{
    private int PDFSize;
}


class Main
{
    public static void main(String[] args)
    {
        Book book1 = new Book();
        System.out.println(book1.getShortName());
        Book book2 = new Book("aut", "title", 10);
        System.out.println(book2.getShortName());

        PrintedBook pbook1 = new PrintedBook();
        System.out.println(pbook1.getShortName()); // a leszármazott osztálynak is van getShortName()-je, örökölte Book-tól
    }
}
