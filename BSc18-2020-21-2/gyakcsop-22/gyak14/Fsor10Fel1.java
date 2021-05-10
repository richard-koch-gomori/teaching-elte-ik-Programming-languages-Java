// Jónás Bendegúz Gergő megoldása Koch-Gömöri Richárd kommentjeivel

import java.io.*;
import java.util.*;

class Book 
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

    public String createRefernce(String article, int start, int end) 
    {
        return getShortName() + " " + start + "-" + end + " referenced in article: " + article; 
    }

    public int getPages()
    {
        return pages;
    }
}

class PrintedBook extends Book
{
    enum CoverType {Softcover, Hardcover};

    private CoverType cover;

    public PrintedBook() 
    {
        //super();
        this.cover = CoverType.Hardcover;
        this.pages += 6; 
    }

    public PrintedBook(String author, String title, int pages, CoverType cover) 
    {
        super(author, title, pages);
        this.cover = CoverType.Hardcover;
        this.pages += 6; 
    }

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

    @Override
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

class Article
{
    private String title;
    private String body;
    private String conc;
    private PrintWriter pw;
    private ArrayList<Book> refs;

    public Article(String title, String body, String conc) 
    {
        this.title = title;
        this.body = body;
        this.conc = conc;
        
        refs = new ArrayList<>();
    }

    public void addBookToReferences(Book b)
    {
        refs.add(b);
    }

    private void printReference(Book b, int from, int to)
    {
        // Book, PrintedBook and EBook have a proper createReference() method, that takes care of proper reference creation.
        // Note here the caller doesn't even have know that book is a Book, PrintedBook or EBook, just the fact that every Book have a createReference() method.
        // Easy to add new kind of Book-s, we just have to take care to define a proper createReference() method.

        // The imperative solution (without method overriding and LSP) would be to check here what the exact type of book,
        // which would result in many if-conditions in the source code, which is not the dream of a programmer.
        pw.print(b.createRefernce(title, from, to) + System.lineSeparator());
    }

    public void print(String dest)
    {
        try
        {
            pw = new PrintWriter(new File(dest));
            pw.print(title + System.lineSeparator());
            pw.print(body + System.lineSeparator());
            pw.print(conc + System.lineSeparator());

            for(Book book : refs)
            {
                printReference(book, 1, book.getPages());
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        finally
        {
            pw.close();
        }
    }
}

public class Fsor10Fel1
{
    public static void main(String[] args)
    {
        Book b1 = new Book();
        System.out.println("b1 " + b1);

        PrintedBook p1 = new PrintedBook();
        System.out.println("p1 " + p1);

        EBook e1 = new EBook("ASD", "EStory of ASD", 420, 520);
        System.out.println("e1 " + e1);

        Article myFiction = new Article("My Fiction", "Bodys", "ok");

        myFiction.addBookToReferences(b1);
        myFiction.addBookToReferences(p1);
        myFiction.addBookToReferences(e1);

        myFiction.print("out.txt");
    }
}
