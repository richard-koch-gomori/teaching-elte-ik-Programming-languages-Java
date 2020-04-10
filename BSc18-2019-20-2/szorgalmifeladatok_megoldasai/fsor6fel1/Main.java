//készítette: Lukács Dávid István
import auto.utils.Color;
import auto.Auto;
import java.io.*;
import java.util.Scanner;
class Main
{
    public static void main(String[] args) 
    {
        File input= new File("input.txt");
        Scanner sc=null;
        int lines = 0;
        try
        {
        Scanner countlines=new Scanner(input);
        while(countlines.hasNextLine())
            {
            lines++;
            countlines.nextLine();
            }
        countlines.close();
        sc = new Scanner(input);
        Auto[] garage = new Auto[lines];
        int idx=0;
        while(sc.hasNextLine())
            {
                String[] Line = sc.nextLine().split(",");
                garage[idx]=new Auto(Line[0],Line[1],Integer.parseInt(Line[2]));
                System.out.println(garage[idx].toString());
                idx++;
            }
            sc.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Unable to access file");
        }
    }
}