
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

// import java.io.*;


class Main
{
    public static void main(String[] args)
    {
        File input = new File(args[0]);
        File output = new File(args[1]);

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(input));
            PrintWriter pw = new PrintWriter(output);

            String line;
            // beolvassuk a fájl következő sorát, majd erre mutat line
            // utána ellenőrizzük hogy a line nem-e null
            // null esetén nincs több beolvasandó sor
            while ((line = br.readLine()) != null)
            {
                // split: részsztringekre bontja a line-t
                String[] parts = line.split(",");

                int sum = 0;
                for (String num : parts)
                {
                    sum += Integer.parseInt(num);
                }

                pw.println(sum);
            }

            // végül a fájlok bezárása
            // a bezárás így még hagy némi kívánnivalót maga után, ld. következő feladat
            br.close();
            pw.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Unable to access file " + args[0]);
        }
        catch (IOException e)
        {
            System.out.println("IO error");
        }
    }
}