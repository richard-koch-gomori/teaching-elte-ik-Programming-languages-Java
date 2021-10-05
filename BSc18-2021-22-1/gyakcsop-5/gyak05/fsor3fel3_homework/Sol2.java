// Ungvári Róbert megoldása

import java.util.Arrays;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;


class Homework
{
    public static void main(String[] args)
    {
        try
        {
            File file = new File(args[0]);
            File output = new File("output.txt");
            BufferedReader br = new BufferedReader( new FileReader( file ));
            PrintWriter pw = new PrintWriter(output);

            String line;
            String[] arr;
            int l, r, num;
            int[] numbers;
            boolean found;
            while ((line = br.readLine()) != null)
            {
                found = false;
                arr = line.split(" ", 0);
                num = Integer.parseInt(arr[0]);
                arr = arr[1].split(",", 0);
                numbers = new int[arr.length];
                for(int i = 0;i < arr.length;i++)
                {                
                    numbers[i] = Integer.parseInt(arr[i]);
                }
                Arrays.sort(numbers);
                l = 0;
                r = numbers.length - 1;
                while (l < r) {
                    if (numbers[l] + numbers[r] == num)
                    {   
                        pw.printf("%d %d %d \n", num, numbers[l], numbers[r]);
                        found = true;
                        break;
                    } else if (numbers[l] + numbers[r] < num)
                    {
                        l++;
                    } else {
                        r--;
                    }    
                }
                if (!found){
                    pw.printf("%d %s\n", num, "none");
                }       
            }
            br.close();
            pw.close();
        }
        catch(Exception e)
        {

        }
    }
}
