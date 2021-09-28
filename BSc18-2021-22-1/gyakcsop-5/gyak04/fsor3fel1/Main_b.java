// b. feladat
// kimeneti fájl (output) paraméterként megadva

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

class Main
{
    public static void main(String[] args) // args[0] tartalmazza az output fájl nevét
    {
        try
        {
            File file = new File("data.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            File output = new File(args[0]);
            PrintWriter pw = new PrintWriter(output);

            String line;
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(",");

                // pl. line == "1,2,5,-2"
                // line.split() tömböt ad eredményül
                // parts.length == 4
                // pl. parts[0] == "1"

                int sum = 0;
                // index szerinti bejárás
                /*for (int i = 0; i < parts.length; ++i)
                {
                    sum += Integer.parseInt(parts[i]);
                }*/

                // for-each ciklus
                for (String item : parts)
                {
                    sum += Integer.parseInt(item);
                }
                //System.out.println(sum);
                pw.println(sum);
            }

            br.close();
            pw.close();
        }
        catch (Exception exc)
        {
        }
    }
}



