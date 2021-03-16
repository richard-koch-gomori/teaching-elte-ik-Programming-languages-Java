
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

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(input));

            String line;
            // beolvassuk a fájl következő sorát, majd erre mutat line
            // utána ellenőrizzük hogy a line nem-e null
            // null esetén nincs több beolvasandó sor
            while ((line = br.readLine()) != null)
            {
                // split: részsztringekre bontja a line-t
                String[] parts = line.split(",");

                int sum = 0;
                for (String num_str : parts)
                {
                    sum += Integer.parseInt(num_str);
                }
                System.out.println(sum);
            }

            // végül a fájl bezárása
            // a bezárás így még hagy némi kívánnivalót maga után, ld. következő feladat
            br.close();
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
