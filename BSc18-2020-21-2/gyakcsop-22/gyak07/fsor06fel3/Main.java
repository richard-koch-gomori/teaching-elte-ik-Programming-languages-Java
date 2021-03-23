

import java.io.*;
import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        System.out.println("Enter a sample: ");
        String sample = System.console().readLine();

        File input = new File(args[0]);

        try
        {
            Scanner sc = new Scanner(input);

            int counter = 0;
            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                //System.out.println(line);

                if (line.contains(sample))
                {
                    counter++;
                }
            }

            System.out.println("counter = " + counter);
            sc.close();
        }
        catch (FileNotFoundException exc)
        {
            System.out.println(exc.getMessage());
        }
    }
}

