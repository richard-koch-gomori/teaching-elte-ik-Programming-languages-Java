

class Book
{
    enum Genre {FANTASY, SATIRE, SCIFI, PHILOSOPHY, EDUCATIONAL};

    private String author;
    private String title;
    private int price;
    private int id;
    private Genre genre;

    private static int next_id = 0;

    // privát konstruktor: a user code nem tudja példányosítani az osztályt new-val
    // (nem tudja a new Book() konstruálást használni)
    private Book(String author, String title, int price, Genre genre)
    {
        this.author = author;
        this.title = title;
        this.price = price;
        this.genre = genre;
        this.id = next_id++;
    }

    // factory függvény
    // egy statikus metódusra bízzuk hogy adatellenőrzéseket végezzen,
    // és ha minden oké, megkonstruál egy Book példányt, majd visszatér annak referenciájával
    public static Book make(String author, String title, int price, Genre genre)
    {
        return new Book(author, title, price, genre);
    }
}

class Main
{
    public static void main(String[] args)
    {
        Book book1 = Book.make("", "", 1, Book.Genre.FANTASY);
    }
}
