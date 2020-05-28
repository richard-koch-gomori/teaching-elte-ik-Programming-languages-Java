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
    public boolean isStudied(String bookName, int page) throws StudyException
    {
        HashSet<Integer> lineElems = bookToPages.get(bookName);
        if (lineElems == null)
        {
            throw new StudyException("Book " + bookName + " is unknown");
        }
        int min = Collections.min(lineElems);
        int max = Collections.max(lineElems);
        return page >= min && page <= max;
    }

    @Override
    public boolean isStudied(String bookName, int from, int to) throws StudyException
    {
        HashSet<Integer> lineElems = bookToPages.get(bookName);
        if (lineElems == null)
        {
            throw new StudyException("Book " + bookName + " is unknown");
        }
        int min = Collections.min(lineElems);
        int max = Collections.max(lineElems);
        return (from >= min && to <= max) || (from <= min && to >= min) || (from <= max && to >= max); // "középen van, elején belelóg, végén belelóg"
        //return (from <= min && to >= max) || (from >= min && from <= max) || (to >= min && to <= max);
    }
}



/*

        min                            max
        _______________________________
                ...........
                from       to

    from      to
    ..........
                                    from          to
                                    ..............

                                                 from       to
                                                 ............

    from                                                    to
    ........................................................
*/

