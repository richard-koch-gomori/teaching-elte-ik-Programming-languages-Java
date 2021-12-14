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

/*
[min; max] és [from; to] zárt intervallumok között van-e átfedés

Stackoverflow:

https://stackoverflow.com/questions/3269434/whats-the-most-efficient-way-to-test-two-integer-ranges-for-overlap

1. válasz: min <= to && from <= max

2. válasz:

Given two ranges [x1,x2], [y1,y2]

def is_overlapping(x1,x2,y1,y2):
    return max(x1,y1) <= min(x2,y2)

max(min, from) <= min(max, to)

---------------------------------------------------------------

Kovács Réka megoldása:

return (from <= min) ? (min <= to) : (from <= max);
*/


