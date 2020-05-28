package study.planner;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        File input = new File("input.txt");

        try
        {
            Scanner sc = new Scanner(input);
            StudyPlanner sp = new StudyPlanner();
            sp.readPagesFromText(sc);
            System.out.println(sp);
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (StudyException e)
        {
            System.out.println(e.getMessage());
        }
    }
}