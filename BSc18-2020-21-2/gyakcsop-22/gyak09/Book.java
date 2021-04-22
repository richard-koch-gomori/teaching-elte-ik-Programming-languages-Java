// Széplaki Bence és Horváth András megoldása

public class Book 
{
    public enum Genre
    {
        FANTASY,SATIRE,SCIFI,PHILOSOPHY,EDUCATIONAL
    };

    private String author;
    private String title;
    private int price;
    private int id;
    private Genre genre;

    static int currentId = 0;

    private Book(String author,String title,int price,Genre genre)
    {
        this.author = author;
        this.title = title;
        this.price = price;
        this.genre = genre;

        this.id = currentId;
        currentId++;
    }

    public static Book Make(String author,String title,int price,String genre) 
    {
        if (author == null || title==null || author.length()<2 || title.length()<2)
        {
            return null;
        }
        for (int i=0; i<title.length(); i++)
        {
            char tmp=title.charAt(i);
            if (!Character.isLetter(tmp) && !Character.isDigit(tmp) && !Character.isWhitespace(tmp))
            {
                return null;
            }
        }
        if (price <= 0)
        {
            return null;
        }
        try {
            return new Book(author,title,price,Genre.valueOf(genre));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
    public int get_id()
    {
        return id;
    }
}