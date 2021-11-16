// öröklődés funkciói:
// - kódöröklés: a leszármazott osztályban is szükség van korábban megírt adattagokra, metódusokra
// - később, ld. 13. gyakorlat


// szülőosztály
class Book
{
    private String author;
    private String title;
    protected int pages; // Book és a Book-ból származó osztályok férhetnek hozzá

    public Book()
    {
        this.author = "John Steinbeck";
        this.title = "Of Mice and Men";
        this.pages = 107;
    }

    public Book(String author, String title, int pages)
    {
        if (author.length() < 2 || title.length() < 4)
        {
            throw new IllegalArgumentException("author or title isn't valid");
        }
        this.author = author;
        this.title = title;
        this.pages = pages;
    }

    public String getShortName()
    {
        return author.substring(0, 2) + ": " + title.substring(0, 4) + ", " + pages;
    }

    // a szülőosztály ezen toString()-jét nyilván örökli PrintedBook és EBook is
    public String toString()
    {
        return author + ": " + title + ", pages: " + pages;
    }

    public String createReference(String article, int from, int to)
    {
        return getShortName() + " " + from + "-" + to + " referenced in article: " + article;
    }
}

enum CoverType
{
    Softcover,
    Hardcover
}

// leszármazott, gyermek osztálya Book-nek
// a konstruktorok nem öröklődnek
// a privát adattagok és függvények öröklődnek, csak nem lehet rájük közvetlenül hivatkozni
// (vmilyen setter-en/getter-en keresztül viszont elérhetőek)
class PrintedBook extends Book
{
    // a PrintedBook-nak ugyanúgy kell minden, ami Book-nak van, de bővíti kódját fedéltípussal (CoverType)

    private CoverType cover;

    public PrintedBook()
    {
        // a szülőosztály paraméter nélküli konstruktorának hívása
        //super(); // ha nem írjuk ki, ideérti a fordító
        this.pages += 6;
        this.cover = CoverType.Hardcover;
    }

    public PrintedBook(String author, String title, int pages, CoverType cover)
    {
        super(author, title, pages); // a szülőosztály ctor-ját hívja
        this.pages += 6;
        this.cover = cover;
    }

    // a gyermekosztály egyéb metódusokat is definiál
    public int getPrice()
    {
        if (cover == CoverType.Softcover)
        {
            return 2*pages;
        }
        else
        {
            return 3*pages;
        }
    }

    // a PrintedBook-nak a szülőosztály toString()-je nem elég jó, ezért ugyanolyan néven
    // és ugyanolyan paraméterezéssel definiál ilyen függvényt
    // ezt hívják felüldefiniálásnak (override)
    public String toString()
    {
        return super.toString() + ", cover: " + cover; // meghívhatja a szülőosztály toString()-jét
    }

    public String createReference(String article, int from, int to)
    {
        return super.toString() + " " + from + "-" + to + " referenced in article: " + article;
    }
}

class EBook extends Book
{
    private int PDFSize;

    public EBook(String author, String title, int pages, int PDFSize)
    {
        super(author, title, pages);
        this.PDFSize = PDFSize;
    }

    // a gyermekosztály egyéb metódusokat is definiál
    public int getPrice()
    {
        return pages + PDFSize;
    }

    // override - felüldefiniálás

    // @Override annotáció: ha a metódus valójában nem is definiálja felül vmely szülőosztálytól örökölt
    // metódust, akkor fordítási hibát kapunk
    // a programozó kifejezi ezzel a szándékát a compiler-nek
    // ha a programozó elrontja a felüldefiniálást, a compiler-nek van lehetősége ezt észrevenni
    @Override
    public String createReference(String article, int from, int to)
    {
        return super.toString() + " (PDF size: " + PDFSize + ") " + from + "-" + to + " referenced in article: " + article;
    }

    // overload - túlterhelés: ugyanolyan néven, de más paraméterekkel definiálunk metódust
    public String createReference(String article, String date)
    {
        return super.toString() + " (PDF size: " + PDFSize + ") referenced in article: " + article + ", accessing PDF date: " + date;
    }
}

class Main
{
    public static void main(String[] args)
    {
        Book book1 = new Book();
        Book book2 = new Book("author2", "title2", 52);
        System.out.println(book1.getShortName());
        System.out.println(book2.getShortName());

        PrintedBook pbook1 = new PrintedBook("pauthor1", "ptitle1", 70, CoverType.Softcover);
        System.out.println(pbook1.getShortName()); // a leszármazott osztálynak is van getShortName()-je, örökölte Book-tól

        EBook ebook1 = new EBook("eauthor1", "etitle1", 80, 1300);
        System.out.println(ebook1.getShortName());

        // c
        System.out.println("---------------------------------");

        System.out.println(book1);
        System.out.println(pbook1);
        System.out.println(ebook1);

        System.out.println("---------------------------------");

        System.out.println(book1.createReference("articlename", 10, 20));
        System.out.println(pbook1.createReference("articlename", 10, 20));
        System.out.println(ebook1.createReference("articlename", 10, 20));
        System.out.println(ebook1.createReference("articlename", "2021/11/16"));
    }
}

