// Jónás Bendegúz Gergő megoldása Koch-Gömöri Richárd kommentjeivel

// öröklődés funkciói:
// - kódöröklés: a leszármazott osztályban is szükség van korábban megírt adattagokra, metódusokra
// - ld. 12. gyakorlat

// alaposztály, ősosztály
class Book 
{
    private String title;
    private String author;
    protected int pages; // Book és a Book-ból származó osztályok férhetnek hozzá

    public Book()
    {
        this.title = "Of Mice and Men";
        this.author = "John Steinbeck";
        this.pages = 107;
    }

    public Book(String author, String title, int pages)
    {
        if(author.length() < 2 || title.length() < 4) 
        {   
            throw new IllegalArgumentException();
        }

        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getShortName() 
    {
        return author.substring(0, 2) + ":" + title.substring(0, 4) + " " + pages;
    }

    // az ősosztály ezen toString()-jét nyilván örökli PrintedBook és EBook is
    public String toString()
    {
        return author + ":" + title + ", " + pages; 
    }

    public String createRefernce(String article, int start, int end) 
    {
        return getShortName() + " " + start + "-" + end + " referenced in article: " + article; 
    }
}

// leszármazmazott, gyermek
// a konstruktorok nem öröklődnek
// a privát adattagok és függvények öröklődnek, csak nem lehet rájük közvetlenül hivatkozni
// (vmilyen setter-en/getter-en keresztül viszont elérhetőek)
class PrintedBook extends Book
{
    // a PrintedBook-nak ugyanúgy kell minden, ami Book-nak van, de bővíti kódját fedéltípussal (CoverType)

    enum CoverType {Softcover, Hardcover};

    private CoverType cover;

    public PrintedBook() 
    {
        // az ősosztály paraméter nélküli konstruktorának hívása
        super(); // ha nem írjuk ki, ideérti a fordító
        this.cover = CoverType.Hardcover;
        this.pages += 6; 
    }

    public PrintedBook(String author, String title, int pages, CoverType cover) 
    {
        // az ősosztály paraméteres konstruktorának hívása
        super(author, title, pages);

        this.cover = CoverType.Hardcover;
        this.pages += 6; 
    }

    // a gyermekosztály egyéb metódusokat is definiál
    public int getPrice() 
    {
        if(cover == CoverType.Hardcover) 
        {
            return pages * 3;    
        }
        else
        {
            return pages * 2;
        }
    }

    // a PrintedBook-nak az ősosztály toString()-je nem elég jó, ezért ugyanolyan néven
    // és ugyanolyan paraméterezéssel definiál ilyen függvényt
    // ezt hívják felüldefiniálásnak (override)
    public String toString() 
    {
        return super.toString() + " " + cover; // meghívhatja az ősosztály toString()-jét
    }

    public String createRefernce(String article, int start, int end) 
    {
        return super.toString() + " " + start + "-" + end + " referenced in article: " + article; 
    }
}

class EBook extends Book
{
    private int pdfSize;

    public EBook(String author, String title, int pages, int pdfSize) {
        super(author, title, pages);
        this.pdfSize = pdfSize; 
    }

    // a gyermekosztály egyéb metódusokat is definiál
    public int getPrice() 
    {
        return pages + pdfSize;
    }

    // @Override annotáció: ha a metódus valójában nem is definiálja felül vmely ősoztálytól örökölt
    // metódust, akkor fordítási hibát kapunk
    // a programozó kifejezi ezzel a szándékát a compiler-nek
    // ha a programozó elrontja a felüldefiniálást, a compiler-nek van lehetősége ezt észrevenni
    @Override
    public String createRefernce(String article, int start, int end) 
    {
        return super.toString() + " (pdf size: " + pdfSize + ") " + start + "-" + end + " referenced in article: " + article; 
    }

    // overload
    //@Override // ford. hiba, ez a metódus nem override, hanem overload
    public String createRefernce(String article, int start, int end, String date) 
    {
        return super.toString() + " (pdf size: " + pdfSize + ") " + start + "-" + end + " referenced in article: " + article + ", accessing PDF date: " + date; 
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Book b1 = new Book();
        System.out.println("b1: " + b1.getShortName());

        Book b2 = new Book("ASD", "BStory of ASD", 69);
        System.out.println("b2: " + b2.getShortName());

        PrintedBook p1 = new PrintedBook();
        System.out.println("p1: " + p1.getShortName()); // a leszármazott osztálynak is van getShortName()-je, örökölte Book-tól

        PrintedBook p2 = new PrintedBook("ASD", "PStory of ASD", 420, PrintedBook.CoverType.Hardcover);
        System.out.println("p2: " + p2.getShortName());

        EBook e1 = new EBook("ASD", "EStory of ASD", 420, 520);
        System.out.println("e1: " + e1.getShortName());

        System.out.println(b1);
        System.out.println(p1);
        System.out.println(e1);

        System.out.println(b1.createRefernce("article name", 5, 10));
        System.out.println(p1.createRefernce("article name", 5, 10));
        System.out.println(e1.createRefernce("article name", 5, 10));
        System.out.println(e1.createRefernce("article name", 5, 10, "2021-04-20"));
    }
}
