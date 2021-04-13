// Széplaki Bence megoldása

public class Book 
{
    enum Genre
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
}

