
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;


class Main
{
    public static void main(String[] args)
    {
        File in = new File(args[0]);

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(in));

            String line;
            while ((line = br.readLine()) != null)
            {
                String[] parts = line.split(",");

                int sum = 0;
                for (String e : parts)
                {
                    sum += Integer.parseInt(e);
                }
                System.out.println(sum);
            }

            br.close();
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

