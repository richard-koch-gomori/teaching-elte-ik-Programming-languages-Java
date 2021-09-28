

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

class Main
{
    public static void main(String[] args)
    {
        try
        {
            File file = new File("data.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null)
            // 1. line értékül kapja a br.readLine() visszatérési értékét
            // 2. line értékét összehasonlítom null-al: line != null
            {
                System.out.println("line = " + line);
            }

            br.close();

            /*
            line = br.readLine();
            while (line != null)
            {
                // line "feldolgozása"

                line = br.readLine();
            }
            */
        }
        catch (Exception exc)
        {
        }
    }
}

