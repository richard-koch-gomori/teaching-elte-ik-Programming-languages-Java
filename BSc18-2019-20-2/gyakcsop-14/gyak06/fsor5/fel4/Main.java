
/*
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
*/

import java.io.*;


class Main
{
    public static void main(String[] args)
    {
        File in = new File(args[0]);
        File out = new File(args[1]);

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(in));
            PrintWriter pw = new PrintWriter(out);

            String line;
            // beolvassuk a fájl következő sorát, majd erre mutat line
            // utána ellenőrizzük hogy a line nem-e null
            // null esetén nincs több beolvasandó sor
            while ((line = br.readLine()) != null)
            {
                // split: részsztringekre bontja a line-t
                String[] parts = line.split(",");

                int sum = 0;
                for (String e : parts)
                {
                    sum += Integer.parseInt(e);
                }
                pw.println(sum);
            }

            // végül a fájlok bezárása
            // a bezárás így még hagy némi kívánnivalót maga után, ld. következő gyakorlat
            br.close();
            pw.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot access file");
        }
        catch (IOException e)
        {
            System.out.println("IO error");
        }
    }
}

