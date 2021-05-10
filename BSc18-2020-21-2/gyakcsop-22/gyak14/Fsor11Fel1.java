// Jónás Bendegúz Gergő megoldása

// Abstract osztály:
// - Tartalmazhat abstract metódust. 
// - Nem példányosítható.
abstract class Book 
{
    private String title;
    private String author;
    protected int pages;

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

    public String toString()
    {
        return author + ":" + title + ", " + pages; 
    }

    abstract public String createRefernce(String article, int start, int end);

    abstract public int getPrice(); // Abstract metódus: Olyan metódus amihez nem tartozik implementáció.
}

class PrintedBook extends Book
{
    enum CoverType {Softcover, Hardcover};

    private CoverType cover;

    public PrintedBook() 
    {
        super();
        this.cover = CoverType.Hardcover;
        this.pages += 6; 
    }

    public PrintedBook(String author, String title, int pages, CoverType cover) 
    {
        super(author, title, pages);

        this.cover = CoverType.Hardcover;
        this.pages += 6; 
    }

    @Override
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

    public String toString() 
    {
        return super.toString() + " " + cover;
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

    @Override
    public int getPrice() 
    {
        return pages + pdfSize;
    }

    @Override
    public String createRefernce(String article, int start, int end) 
    {
        return super.toString() + " (pdf size: " + pdfSize + ") " + start + "-" + end + " referenced in article: " + article; 
    }

    public String createRefernce(String article, int start, int end, String date) 
    {
        return super.toString() + " (pdf size: " + pdfSize + ") " + start + "-" + end + " referenced in article: " + article + ", accessing PDF date: " + date; 
    }
}

public class Main
{
    public static void main(String[] args)
    {
        PrintedBook p1 = new PrintedBook();
        System.out.println("p1: " + p1.getShortName());

        PrintedBook p2 = new PrintedBook("ASD", "PStory of ASD", 420, PrintedBook.CoverType.Hardcover);
        System.out.println("p2: " + p2.getShortName());

        EBook e1 = new EBook("ASD", "EStory of ASD", 420, 520);
        System.out.println("e1: " + e1.getShortName());

        System.out.println(p1);
        System.out.println(e1);

        System.out.println(p1.createRefernce("article name", 5, 10));
        System.out.println(e1.createRefernce("article name", 5, 10));
        System.out.println(e1.createRefernce("article name", 5, 10, "2021-04-20"));
    }
}
