

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

    // az ősosztály ezen toString()-jét nyilván örökli PrintedBook és EBook is
    public String toString()
    {
        return author + ": " + title + ", pages: " + pages;
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
    }

    public PrintedBook(String author, String title, int pages, CoverType cover)
    {
        super(author, title, pages);
        this.cover = cover;
        this.pages += 6;
    }

    public int getPrice()
    {
        if (cover == CoverType.Softcover)
            return pages * 2;
        else
            return pages * 3;
    }

    // a PrintedBook-nak az ősosztály toString()-je nem elég jó, ezért ugyanolyan néven
    // és ugyanolyan paraméterezéssel definiál ilyen függvényt
    // ezt hívják felüldefiniálásnak (override)
    public String toString()
    {
        if (cover == CoverType.Softcover)
            return super.toString() + " (softcover)"; // meghívhatja az ősosztály toString()-jét
        else
            return super.toString() + " (hardcover)";
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
}


class Main
{
    public static void main(String[] args)
    {
        Book book1 = new Book();
        System.out.println(book1.getShortName());
        Book book2 = new Book("aut", "title", 10);
        System.out.println(book2.getShortName());
        System.out.println(book1.toString());

        PrintedBook pbook1 = new PrintedBook();
        System.out.println(pbook1.getShortName());
        PrintedBook pbook2 = new PrintedBook("PrintedBook author2", "PrintedBook title2", 2000, CoverType.Softcover);
        System.out.println(pbook2.getShortName());
        System.out.println(pbook2.getPrice());
        System.out.println(pbook2.toString());

        EBook ebook1 = new EBook("EBook author", "EBook title", 200, 10);
        System.out.println(ebook1.getPrice());
        System.out.println(ebook1.toString());
    }
}

