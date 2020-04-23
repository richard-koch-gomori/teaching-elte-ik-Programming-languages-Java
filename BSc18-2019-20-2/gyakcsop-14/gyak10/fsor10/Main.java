


class Book
{
    private String author, title;
    protected int pages;

    public String getAuthor()
    {
        System.out.println("Base getAuthor()");
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

        /*
        Book book4 = new Book();
        System.out.println(book4.getAuthor());

        Book book5 = new PrintedBook();
        System.out.println(book5.getAuthor());

        isSameAuthor(book4, book5);
        */

        // ez a kód lefordul, de futáskor ClassCastException váltódik ki
        // a book1 nem konvertálható PrintedBook-ká, de ez teljesen ésszerű:
        // nincsen fedele, nincsen getPrice()-a etc...
        //PrintedBook pbook3 = (PrintedBook)book1;
        //System.out.println(pbook3.getPrice());
    }
}
