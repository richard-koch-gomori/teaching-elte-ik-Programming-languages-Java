

class Book
{
    private String author, title;
    protected int pages;

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


enum CoverType
{
    Softcover,
    Hardcover;
}


// a PrintedBook-nak ugyanúgy kell minden, ami Book-nak van, de bővíti kódját fedéltípussal (CoverType)
class PrintedBook extends Book
{
    private CoverType cover;

    public PrintedBook()
    {
        // az ősosztály paraméter nélküli konstruktorának hívása
        super();
    }

    public PrintedBook(String author, String title, int pages, CoverType cover)
    {
        // az ősosztály paraméteres konstruktorának hívása
        super(author, title, pages);

        this.cover = cover;
        this.pages += 6;
    }

    // a gyermekosztály egyéb metódusokat is definiál
    public int getPrice()
    {
        if (cover == CoverType.Softcover)
            return pages * 2;
        else
            return pages * 3;
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
        System.out.println(pbook1.getShortName());
        PrintedBook pbook2 = new PrintedBook("PrintedBook author2", "PrintedBook title2", 2000, CoverType.Softcover);
        System.out.println(pbook2.getShortName());
        System.out.println(pbook2.getPrice());

        EBook ebook1 = new EBook("EBook author", "EBook title", 200, 10);
        System.out.println(ebook1.getPrice());
    }
}

