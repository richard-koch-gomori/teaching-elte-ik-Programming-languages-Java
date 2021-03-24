
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

        BufferedReader br = null;
        PrintWriter pw = null;
        try
        {
            br = new BufferedReader(new FileReader(input));
            pw = new PrintWriter(output);

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
            //br.close();
            //pw.close(); // ha a vezérlés nem jut el idáig, nem biztos h bezárjuk
        }
        catch (FileNotFoundException exc)
        {
            System.out.println("Unable to open file: " + exc.getMessage());
        }
        catch (IOException exc)
        {
            System.out.println("IOException thrown");
        }
        // a finally{} blokkba írt kód mindenképpen végrehajtásra kerül, így biztos h bezárjuk sc-t
        finally
        {
            try
            {
                br.close();
                pw.close();
            }
            catch (IOException exc)
            {
                System.out.println("Unable to close file" + exc.getMessage());
            }
        }
    }
}

