// FÉLKÉSZ megoldás, a feladat megoldását konzultáción folytatjuk


package study.planner;

import java.util.*;
import java.io.*;

public class StudyPlanner {
    HashMap<String, HashSet<Integer>> bookToPages;

    public StudyPlanner()
    {
        bookToPages = new HashMap<>();
    }

    public void readPagesFromText(Scanner sc) throws StudyException {
        int lineCount = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < lineCount; i++) {
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
            if (lineElems == null)   lineElems = new HashSet<>();

            for (int j = from; j <= to; j++) {
                if (lineElems.contains(j))   throw new StudyException("Book " + bookName + " already contains page " + j);
                lineElems.add(j);
            }

            bookToPages.put(bookName, lineElems);
        }
    }

    private String joinTexts(int idx, String[] split) {
        StringBuilder retVal = new StringBuilder();
        for (int i = idx; i < split.length; i++) {
            retVal.append(" ");
            retVal.append(split[i]);
        }
        return retVal.toString();
    }

    public String toString()
    {
        return bookToPages.toString();
    }
}


/*
https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html

private: csak osztály
package-private (nem írunk módosítószót): csak az azonos pakage-ben lévő osztáyok férnek hozzá
protected: azonos csomag, illetve a leszármazottak
public: mindenki


Modifier    Class   Package Subclass    World

public      Y       Y       Y           Y
protected	Y	    Y	    Y	        N
no modifier	Y	    Y	    N	        N
private     Y	    N	    N	        N


"Analizis" -> {20, 21, 22, ..., 129, 130}
String -> HashSet<Integer>
*/
