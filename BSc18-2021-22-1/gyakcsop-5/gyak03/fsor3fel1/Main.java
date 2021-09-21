

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
            String line = br.readLine();
            String line2 = br.readLine();
            System.out.println("line = " + line);
            System.out.println("line2 = " + line2);
        }
        catch (Exception exc)
        {
        }
    }
}

