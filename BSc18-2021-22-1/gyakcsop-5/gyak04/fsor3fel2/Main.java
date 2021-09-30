// Dobos Dávid megoldása

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;


class Main
{
    public static void main(String[] args)
    {
        try
        {
            File file = new File(args[0]);
            BufferedReader br = new BufferedReader( new FileReader( file ));

            int db = 0;
            String szoveg;
            System.out.print("A keresett szoveg: ");
            szoveg = System.console().readLine();

            String line;
            while ((line = br.readLine()) != null)
            {
                if(line.contains(szoveg))
                {
                    ++db;
                }
            }

            br.close();

            System.out.println("Az input " + db + " sorban tartalmazta a " + szoveg + " sztringet.");
        }
        catch(Exception e)
        {

        }
    }
}


