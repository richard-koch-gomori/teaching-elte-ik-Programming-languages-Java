// Dontsova Karolina megoldása

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

class SumFinder {
  public static void main(String[] args)
  {
    try
        {
            File file = new File(args[0]);
            BufferedReader br = new BufferedReader( new FileReader( file ));

            File output = new File("out.txt");
            PrintWriter pw = new PrintWriter(output);

            String line;
            while ((line = br.readLine()) != null)
            {
              
              String[] parts = line.split(" ");
              int number = Integer.parseInt(parts[0]);

              String[] elements = parts[1].split(",");
              Boolean found = false;
              
              for(int i = 0; i<elements.length; ++i)
              {
                for(int j = i+1; j<elements.length; ++j)
                {
                  if(found == false)
                {
                  if((Integer.parseInt(elements[i]) + Integer.parseInt(elements[j])) == number)
                {
                  //System.out.println(number + " " + elements[i] + " " + elements[j]);
                  pw.println(number + " " + elements[i] + " " + elements[j]);
                  found = true;
                }
                }
              }
              }
              if(found == false){
                //System.out.println(number + " none");
                pw.println(number + " none");
              }
              found = false;

            }

            br.close();
            pw.close();

           
        }
        catch(Exception e)
        {

        }
  } 
}
