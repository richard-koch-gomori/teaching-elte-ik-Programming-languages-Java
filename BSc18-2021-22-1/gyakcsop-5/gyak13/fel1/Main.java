
abstract class Book
{
    private String author;
    private String title;
    protected int pages;

    public Book()
    {
        //System.out.println("I'm Book");

        this.author = "John Steinbeck";
        this.title = "Of Mice and Men";
        this.pages = 107;
    }

    public Book(String author, String title, int pages)
    {
        //System.out.println("I'm Book");

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

    public String toString()
    {
        return author + ": " + title + ", pages: " + pages;
    }

    abstract public String createReference(String article, int from, int to);
    abstract public int getPrice();
}

enum CoverType
{
    Softcover,
    Hardcover
}

class PrintedBook extends Book
{
    private CoverType cover;

    public PrintedBook()
    {
        //super(); // ha nem írjuk ki, ideérti a fordító
        //System.out.println("I'm Derived");
        this.pages += 6;
        this.cover = CoverType.Hardcover;
    }

    public PrintedBook(String author, String title, int pages, CoverType cover)
    {
        super(author, title, pages);
        //System.out.println("I'm Derived");
        this.pages += 6;
        this.cover = cover;
    }

    @Override
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

    public String toString()
    {
        return super.toString() + ", cover: " + cover;
    }

    @Override
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

    public int getPrice()
    {
        return pages + PDFSize;
    }

    @Override
    public String createReference(String article, int from, int to)
    {
        return super.toString() + " (PDF size: " + PDFSize + ") " + from + "-" + to + " referenced in article: " + article;
    }

    public String createReference(String article, String date)
    {
        return super.toString() + " (PDF size: " + PDFSize + ") referenced in article: " + article + ", accessing PDF date: " + date;
    }
}

class Main
{
    // Book book = new PrintedBook()
    // book változó statikus típusa: Book, dinamikus típusa: PrintedBook
    
    //public static void foo(Book book)
    //{
    //    System.out.println("katalogóus: " + book.getPrice())
    //}

    public static void main(String[] args)
    {
        Book book = new PrintedBook();
        System.out.println(book.createReference("article", 10, 20));
    }
}


