

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

    // @Override annotáció: ha a metódus valójában nem is definiálja felül vmely ősoztálytól örökölt
    // metódust, akkor fordítási hibát kapunk
    // a programozó kifejezi ezzel a szándékát a compiler-nek
    // ha a programozó elrontja a felüldefiniálást, a compiler-nek van lehetősége ezt észrevenni
    @Override
    public String createReference(String article, int from, int to)
    {
        return super.toString() + "(PDF size: " + PDFSize + ") [" + from + "-" + to + "] referenced in article: " + article;
    }

    // overload
    //@Override // ford. hiba, ez a metódus nem override, hanem overload
    public String createReference(String article, String date)
    {
        return super.toString() + "(PDF size: " + PDFSize + ") referenced in article: " + article + ", accessing PDF date: " + date;
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
        System.out.println("(C): " + book1.toString());

        PrintedBook pbook1 = new PrintedBook();
        System.out.println(pbook1.getShortName());
        PrintedBook pbook2 = new PrintedBook("PrintedBook author2", "PrintedBook title2", 2000, CoverType.Softcover);
        System.out.println(pbook2.getShortName());
        System.out.println(pbook2.getPrice());
        System.out.println("(C): " + pbook2.toString());

        EBook ebook1 = new EBook("EBook author", "EBook title", 200, 10);
        System.out.println(ebook1.getPrice());
        System.out.println("(C): " + ebook1.toString());

        System.out.println("---------------------------------");
        System.out.println(book1.createReference("article", 20, 30));
        System.out.println(pbook2.createReference("article2", 40, 55));
        System.out.println(ebook1.createReference("article3", 100, 200));
        System.out.println(ebook1.createReference("article4", "2020/04/21"));
    }
}

