package study.planner.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        }
        assertEquals(0, sp.getBookCount());
    }

    @Test
    public void exampleBookCount()
    {
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
        Scanner sc = new Scanner(text);
        StudyPlanner sp = new StudyPlanner();

        try
        {
            sp.readPagesFromText(sc);
        }
        catch (StudyException e)
        {
            System.out.println(e.getMessage());
        }

        assertEquals(2, sp.getBookCount());
    }
}

