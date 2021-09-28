// a. feladat

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
            {
                String[] parts = line.split(",");

                // pl. line == "1,2,5,-2"
                // line.split() tömböt ad eredményül
                // parts.length == 4
                // pl. parts[0] == "1"

                int sum = 0;
                for (int i = 0; i < parts.length; ++i)
                {
                    sum += Integer.parseInt(parts[i]);
                }
                System.out.println(sum);
            }

            br.close();
        }
        catch (Exception exc)
        {
        }
    }
}

