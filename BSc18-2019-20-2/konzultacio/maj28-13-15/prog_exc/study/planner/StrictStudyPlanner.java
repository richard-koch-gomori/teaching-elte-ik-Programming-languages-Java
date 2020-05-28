package study.planner;

import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;


public class StrictStudyPlanner extends StudyPlanner
{
    @Override
    public int pageCountOf(String bookName) throws StudyException
    {
        HashSet<Integer> lineElems = bookToPages.get(bookName);
        if (lineElems == null)
        {
            throw new StudyException("Book " + bookName + " is unknown");
        }
        int min = Collections.min(lineElems);
        int max = Collections.max(lineElems);
        return max - min + 1;
    }

    @Override
    public boolean isStudied()
    {

    }

    @Override
    public boolean isStudied()
    {
        
    }
}

