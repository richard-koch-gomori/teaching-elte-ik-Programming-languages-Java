package study.planner;

/*
study.planner.StudyPlanner
teljesen minősített név (fully qualified name)
*/

// import java.util.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;


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
}
