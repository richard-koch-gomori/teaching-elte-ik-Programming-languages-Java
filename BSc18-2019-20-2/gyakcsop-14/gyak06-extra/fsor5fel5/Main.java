
import java.io.*;
import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        if (args.length < 1)
        {
            System.out.println("Min. 1 argumentum required");
        }
        else
        {
            System.out.print("Enter a text: ");
            String sample = System.console().readLine();

            File input = new File(args[0]);

            Scanner sc = null;
            try
            {
                int counter = 0;

                sc = new Scanner(input);
                while (sc.hasNextLine())
                {
                    String line = sc.nextLine();

                    //System.out.println(line);
                    if (line.contains(sample))
                    {
                        counter++;
                    }
                }

                System.out.println("counter = " + counter);
                // sc.close(); // ha a vezérlés nem jut el idáig, nem biztos h bezárjuk sc-t
            }
            catch (FileNotFoundException e)
            {
                System.out.println("Cannot open file: " + args[0]);
            }
            // a finally{} blokkba írt kód mindenképpen végrehajtásra kerül, így biztos h bezárjuk sc-t
            finally
            {
                sc.close();
            }
        }
    }
}
