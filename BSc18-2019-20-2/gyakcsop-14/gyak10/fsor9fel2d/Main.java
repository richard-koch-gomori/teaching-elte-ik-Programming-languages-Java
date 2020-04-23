


class Book
{
    private String author, title;
    protected int pages;

    public String getAuthor()
    {
        return author;
    }

    public Book()
    {
        this.author = "John Steinbeck";
        this.title = "Of Mice and Men";
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

    public String toString()
    {
        return author + ": " + title + ", pages: " + pages;
    }

    public String createReference(String article, int from, int to)
    {
        return getShortName() + " [" + from + "-" + to + "] referenced in article: " + article;
    }
}


enum CoverType
{
    Softcover,
    Hardcover;
}


class PrintedBook extends Book
{
    private CoverType cover;

    public PrintedBook()
    {
        super();
        this.pages += 6;
    }

    public PrintedBook(String author, String title, int pages, CoverType cover)
    {
        super(author, title, pages + 6);
        this.cover = cover;
    }

    public int getPrice()
    {
        if (cover == CoverType.Softcover)
            return pages * 2;
        else
            return pages * 3;
    }

    public String toString()
    {
        if (cover == CoverType.Softcover)
            return super.toString() + " (softcover)";
        else
            return super.toString() + " (hardcover)";
    }

    @Override
    public String createReference(String article, int from, int to)
    {
        return super.toString() + " [" + from + "-" + to + "] referenced in article: " + article;
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

    public int getPrice()
    {
        return pages + PDFSize;
    }

    @Override
    public String createReference(String article, int from, int to)
    {
        return super.toString() + " (PDF size: " + PDFSize + ") [" + from + "-" + to + "] referenced in article: " + article;
    }

    public String createReference(String article, String date)
    {
        return super.toString() + " (PDF size: " + PDFSize + ") referenced in article: " + article + ", accessing PDF date: " + date;
    }
}


class Main
{
    /*
    eldönti, hogy két könyv szerzője ugyanaz-e
    a paraméter típusa Book, de a metódus meghívható minden Book vagy Book-ból származó objektum referenciájával is
    ez az LSP elv (Liskov Substitution Principle, Liskov-féle helyettesítési) szabály miatt van

    Functions that use pointers or references to base classes must be able to use objects of derived
    classes without knowing it. (Stackoverflow)

    A szülő osztály példányának referenciája bármikor helyettesíthető a leszármazott osztály
    példányának referenciájával.

    ez több ízben is hasznos, pl nem kell külön isSameAuthor metódust írni PrintedBook-re, Ebook-re
    ha a metódushíváskor PrintedBook-ok vagy Ebook-ot kap, az nem okoz gondot, hiszen nekik is
    biztosan van getAuthor() metódusa (hiszen öröklik a Book-tól)
    */
    public static boolean isSameAuthor(Book book1, Book book2)
    {
        return book1.getAuthor().equals(book2.getAuthor());
    }

    public static void main(String[] args)
    {
        Book book1 = new Book();
        System.out.println("book1 = " + book1.getShortName());
        Book book2 = new Book("Author", "Title", 1000);
        System.out.println("book2 = " + book2.getShortName());
        System.out.println(book2);

        PrintedBook pbook1 = new PrintedBook("Richárd", "Baics Java", 30000, CoverType.Softcover);
        System.out.println(pbook1.getShortName());
        System.out.println("pbook1 price = " + pbook1.getPrice());
        System.out.println(pbook1);

        EBook ebook1 = new EBook("Author4", "Digitalised: Title", 2333, 100);
        System.out.println(ebook1.getShortName());
        System.out.println("ebook1 price = " + ebook1.getPrice());
        System.out.println(ebook1);

        System.out.println("------------------------------------");
        System.out.println(book2.createReference("article1", 10, 20));
        System.out.println(pbook1.createReference("article2", 30, 50));
        System.out.println(ebook1.createReference("article3", 100, 200));
        System.out.println(ebook1.createReference("article4", "2020/04/22"));

        System.out.println(isSameAuthor(book1, book2));
        System.out.println(isSameAuthor(book1, pbook1));

        Book book3 = new PrintedBook();
        System.out.println(book3.getAuthor());
        // ez viszont nem fordul le:
        //System.out.println(book3.getPrice());
        // a book3 típusa Book, a getPrice()-t a book3-on hívom meg, ami Book,
        // aminek nincs getPrice()-ja -> fordítási hiba; ez nem korlátozás, az LSP nem erre való
        // teljesen ésszerű, hogy ha getPrice()-ra van szükségem, akkor PrintedBook-ként deklarálom
    }
}
