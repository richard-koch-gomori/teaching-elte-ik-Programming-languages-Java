
/*
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;
*/

import java.io.*;

class Main
{
    public static void main(String[] args)
    {
        File input = new File("in.txt");
        File output = new File("out.txt");

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(input));
            PrintWriter pw = new PrintWriter(output);

            String line = "";
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(",");

                int sum = 0;
                for (String num_str : parts)
                {
                    sum += Integer.parseInt(num_str);
                }
                pw.print(sum + System.lineSeparator());
                //System.out.println(sum);
            }

            // végül a fájl bezárása
            // a bezárás így még hagy némi kívánnivalót maga után, ld. következő feladat
            br.close();
            pw.close();
        }
        catch (FileNotFoundException exc)
        {
            System.out.println("Unable to open file: " + exc.getMessage());
        }
        catch (IOException exc)
        {
            System.out.println("IOException thrown");
        }
    }
}

