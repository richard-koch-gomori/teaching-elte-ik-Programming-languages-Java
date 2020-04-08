

public class Book
{
    public enum Genre
    {
        FANTASY, SATIRE, SCIFI, PHILOSOPHY, EDUCATIONAL;
    }

    private final String author, title;
    private final int price, id;
    private final Genre genre;

    private static int lastId = 0;
    public static void resetId() { lastId = 0; }

    public int getReservePrice() { return price; }
    public int getId() { return id; }

    private Book(String author, String title, Genre genre, int price)
    {
        this.author = author;
        this.title = title;
        this.price = price;
        this.genre = genre;

        // minden Book objektumnak egyedi ID-ja van
        this.id = lastId++;
    }

    public static Book make(String author, String title, String genreStr, String priceStr)
    {
        try
        {
            int reservePrice = Integer.parseInt(priceStr);

            // a feladat adta feltételek, mikor validad egy Book adatai
            if (author == null || title == null || author.length() < 2 || author.length() < 2 || reservePrice < 0)
            {
                return null;
            }

            Genre genre = Genre.valueOf(genreStr);

            for (int i = 0; i < title.length(); ++i)
            {
                char ch = title.charAt(i);
                if (Character.isLetter(ch) || Character.isDigit(ch) || Character.isWhitespace(ch))
                {
                    // do nothing
                }
                else
                {
                    return null;
                }
            }

            return new Book(author, title, genre, reservePrice);
        }
        // kivételek vagy invalid adatok esetén null-t adjunk vissza
        catch (NumberFormatException e)
        {
            return null;
        }
        catch (IllegalArgumentException e)
        {
            return null;
        }
    }

    public static boolean isSameGenre(Book b1, Book b2)
    {
        return b1.genre == b2.genre;
    }

    public int compare(Book that)
    {
        // isSameGenre() refeket vár, a két összehasonlítandó Book refjét
        // itt az aktuális (this) és a that objektumot hasonlítjuk össze
        if (!isSameGenre(this, that))
        {
            throw new IllegalArgumentException();
        }

/*
        if (price > that.price)
            return 1;
        else if (price == that.price)
            return 0;
        else
            return -1;
*/

        // ez ugyanazt csinálja, mint amit az előbb kikommenteztem
        return Integer.compare(this.price, that.price);
    }
}

