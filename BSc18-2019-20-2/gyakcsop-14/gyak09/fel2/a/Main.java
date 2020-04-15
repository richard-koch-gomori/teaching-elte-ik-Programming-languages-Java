

// öröklődés funkciója:
// - kódöröklés
// - ld. köv. gyakorlaton

class Book
{
    private String author, title;
    protected int pages;

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
}


class PrintedBook extends Book
{

}


class EBook extends Book
{

}


class Main
{
    public static void main(String[] args)
    {
        Book book1 = new Book();
        System.out.println("book1 = " + book1.getShortName());
        Book book2 = new Book("Author", "Title", 1000);
        System.out.println("book2 = " + book2.getShortName());

        PrintedBook pbook1 = new PrintedBook();
        System.out.println(pbook1.getShortName());
    }
}