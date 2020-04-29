

// csak absztrakt osztálynak lehet absztrakt metódusa
abstract class Book
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

    // absztrakt metódus: nincs implementációja (törsze)
    abstract public int getPrice();
    abstract public String createReference(String article, int from, int to);
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

    // a leszármazott osztályoknak kötelező implementálnia az ősosztály absztrakt metódusait
    // ez ad egy "vázat" az osztályszervezésnek
    // az absztrakt osztályból való származtatás garanciát ad arra, hogy az osztály megvalósítja az ősosztály absztrakt metódusait
    @Override
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

    @Override
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
    public static boolean isSameAuthor(Book book1, Book book2)
    {
        // a Book típusú referencián hívható már getPrice(), mert a Book-nak van getPrice() metódusa
        //book1.getPrice();
        return book1.getAuthor().equals(book2.getAuthor());
    }

    public static void main(String[] args)
    {
        Book pbook = new PrintedBook("author", "Printed: Title", 100, CoverType.Softcover);
        System.out.println(pbook);
        // a Book típusú referencián hívható már getPrice(), mert a Book-nak van getPrice() metódusa
        System.out.println(" price = " + pbook.getPrice());
        EBook ebook = new EBook("author2", "Digitalised: Title", 100, 12);
        System.out.println(ebook);
        System.out.println(" price = " + ebook.getPrice());

        System.out.println();

        System.out.println(pbook.createReference("articlename", 10, 20));
        System.out.println(ebook.createReference("articlename", "2020/04/11"));
        System.out.println(ebook.createReference("articlename", 10, 20));

        // absztrakt osztály nem példányosítható, abból csak leszármazni lehet
        //Book book = new Book();
        //book.getPrice();
    }
}
