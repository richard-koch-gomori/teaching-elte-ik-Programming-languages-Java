package study.planner;

/*
study.planner.StudyPlanner
teljesen minősített név (fully qualified name)
*/

// import java.util.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;


public class StudyPlanner
{
    HashMap<String, HashSet<Integer>> bookToPages;

    public StudyPlanner()
    {
        bookToPages = new HashMap<String, HashSet<Integer>>();
    }

    public void readPagesFromText(Scanner sc) throws StudyException
    {
        int lineCount = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < lineCount; i++)
        {
            String line = sc.nextLine();
            String[] split = line.split(" ");

            if (split.length < 3)
            {
                continue;
            }

            int from = Integer.parseInt(split[0]);
            int to = Integer.parseInt(split[1]);
            String bookName = joinTexts(2, split);

            HashSet<Integer> lineElems = bookToPages.get(bookName);
            if (lineElems == null) lineElems = new HashSet<>();

            for (int j = from; j <= to; j++) {
                if (lineElems.contains(j)) throw new StudyException("Book " + bookName + " already contains page " + j);
                lineElems.add(j);
            }

            bookToPages.put(bookName, lineElems);
        }
    }

    private String joinTexts(int idx, String[] split) {
        StringBuilder retVal = new StringBuilder();
        retVal.append(split[idx]);
        for (int i = idx + 1; i < split.length; i++) {
            retVal.append(" ");
            retVal.append(split[i]);
        }
        return retVal.toString();
    }

    @Override
    public String toString()
    {
        return bookToPages.toString();
    }

    public int getBookCount()
    {
        return bookToPages.size();
    }

    public int pageCountOf(String bookName) throws StudyException
    {
        HashSet<Integer> lineElems = bookToPages.get(bookName);
        if (lineElems == null)
        {
            throw new StudyException("Book " + bookName + " is unknown");
        }
        return lineElems.size();
    }

    public boolean isStudied(String bookName, int page) throws StudyException
    {
        HashSet<Integer> lineElems = bookToPages.get(bookName);
        if (lineElems == null)
        {
            throw new StudyException("Book " + bookName + " is unknown");
        }
        return lineElems.contains(page);
    }

    public boolean isStudied(String bookName, int from, int to) throws StudyException
    {
        HashSet<Integer> lineElems = bookToPages.get(bookName);
        if (lineElems == null)
        {
            throw new StudyException("Book " + bookName + " is unknown");
        }

        for (int i = from; i <= to; ++i)
        {
            //if (isStudied(bookName, i))
            if (lineElems.contains(i))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object that)
    {
        if (that == null)
        {
            return false;
        }
        if (that == this)
        {
            return true;
        }
        if (that instanceof StudyPlanner)
        {
            StudyPlanner sp = (StudyPlanner)that;
            return this.bookToPages.equals(sp.bookToPages);
        }
        else return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.bookToPages);
    }
}
