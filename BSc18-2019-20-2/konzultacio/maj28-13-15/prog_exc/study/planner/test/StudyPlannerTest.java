package study.planner.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import java.util.Scanner;

import study.planner.StudyPlanner;
import study.planner.StudyException;


public class StudyPlannerTest
{
    @Test
    public void noLines()
    {
        Scanner sc = new Scanner("0");
        StudyPlanner sp = new StudyPlanner();
        try
        {
            sp.readPagesFromText(sc);
        }
        catch (StudyException e)
        {
            System.out.println(e.getMessage());
            fail();
        }
        assertEquals(0, sp.getBookCount());
    }

    @Test
    public void exampleBookCount() throws StudyException
    {
        /*
        StringBuilder sb = new StringBuilder();
        sb.append("4");
        sb.append(System.lineSeparator());
        sb.append("10 20 Programozasi Nyelvek Java");
        sb.append(System.lineSeparator());
        sb.append("150 190 Analizis");
        sb.append(System.lineSeparator());
        sb.append("20 130 Analizis");
        sb.append(System.lineSeparator());
        sb.append("55 78 Programozasi Nyelvek Java");
        String text = sb.toString();
        */

        String text = 
            "4" + 
            System.lineSeparator() + 
            "10 20 Programozasi Nyelvek Java" + 
            System.lineSeparator() + 
            "150 190 Analizis" + 
            System.lineSeparator() + 
            "20 130 Analizis" + 
            System.lineSeparator() + 
            "55 78 Programozasi Nyelvek Java";

        Scanner sc = new Scanner(text);
        StudyPlanner sp = new StudyPlanner();

        /*
        try
        {
            sp.readPagesFromText(sc);
        }
        catch (StudyException e)
        {
            System.out.println(e.getMessage());
            fail();
        }
        assertEquals(2, sp.getBookCount());
        */

        sp.readPagesFromText(sc);
        assertEquals(2, sp.getBookCount());
    }

    @Test
    public void examplePageCount_Analizis() throws StudyException
    {
        String text = 
            "4" + 
            System.lineSeparator() + 
            "10 20 Programozasi Nyelvek Java" + 
            System.lineSeparator() + 
            "150 190 Analizis" + 
            System.lineSeparator() + 
            "20 130 Analizis" + 
            System.lineSeparator() + 
            "55 78 Programozasi Nyelvek Java";

        Scanner sc = new Scanner(text);
        StudyPlanner sp = new StudyPlanner();

        sp.readPagesFromText(sc);
        assertEquals(152, sp.pageCountOf("Analizis"));
    }

    @Test
    public void examplePageCount_Java() throws StudyException
    {
        String text = 
            "4" + 
            System.lineSeparator() + 
            "10 20 Programozasi Nyelvek Java" + 
            System.lineSeparator() + 
            "150 190 Analizis" + 
            System.lineSeparator() + 
            "20 130 Analizis" + 
            System.lineSeparator() + 
            "55 78 Programozasi Nyelvek Java";

        Scanner sc = new Scanner(text);
        StudyPlanner sp = new StudyPlanner();

        sp.readPagesFromText(sc);
        assertEquals(35, sp.pageCountOf("Programozasi Nyelvek Java"));
    }

    @Test(expected = StudyException.class)
    public void missingBook() throws StudyException
    {
        String text = 
            "4" + 
            System.lineSeparator() + 
            "10 20 Programozasi Nyelvek Java" + 
            System.lineSeparator() + 
            "150 190 Analizis" + 
            System.lineSeparator() + 
            "20 130 Analizis" + 
            System.lineSeparator() + 
            "55 78 Programozasi Nyelvek Java";

        Scanner sc = new Scanner(text);
        StudyPlanner sp = new StudyPlanner();

        sp.readPagesFromText(sc);
        sp.pageCountOf("missingBook");
    }
}

