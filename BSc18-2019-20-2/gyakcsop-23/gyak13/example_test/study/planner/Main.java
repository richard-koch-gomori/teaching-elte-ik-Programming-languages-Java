package study.planner;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner("1" + System.lineSeparator() + "10 20 Programozasi Nyelvek Java");
        StudyPlanner sp = new StudyPlanner();
        sp.readPagesFromText(sc);

        System.out.println(sp);
    }
}