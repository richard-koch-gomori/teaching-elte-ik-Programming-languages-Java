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
}

