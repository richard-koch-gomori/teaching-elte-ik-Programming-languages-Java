

public class Book
{
    static enum Genre
    {
        FANTASY, SATIRE, SCIFI, PHILOSOPHY, EDUCATIONAL;
    }

    private String author;
    private String title;
    private int price;
    private int id;
    private Genre genre;

    private static int next_id; 
    public static void resetId() { next_id = 0; }

    public int getPrice() { return price; }
    public int getId() { return id; }

    private Book(String author, String title, Genre genre, int price)
    {
        this.author = author;
        this.title = title;
        this.price = price;
        this.genre = genre;
        id = next_id++;
    }

    public static Book make(String author, String title, int price, String genreName)
    {      
        try
        {
            if (author == null || title == null || title.length() < 2 || price <= 0)
                return null;

            Genre g = Genre.valueOf(genreName);

            int i = 0;
            while (i < title.length())
            {
                if (Character.isLetter(title.charAt(i)) || Character.isDigit(title.charAt(i)) || Character.isWhitespace(title.charAt(i)))
                {
                    ++i;
                }
                else
                {
                    return null;
                }
            }
            return new Book(author, title, g, price);
        }
        catch (IllegalArgumentException e)
        {
            return null;
        }
    }

    public static Book make2(String author, String title, Genre g, int price)
    {
        if (author == null || title == null || title.length() < 2 || price <= 0)
            throw new IllegalArgumentException();

        return new Book(author, title, g, price);
    }
}


