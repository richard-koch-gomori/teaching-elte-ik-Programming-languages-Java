//Készítette: Korom Pál Gábor
import java.io.*;

class Main{

    public static void main(String[] args){
        
        File input = new File("input.txt");
        File output = new File("output.txt");

        //try-with-resources
        try (BufferedReader br = new BufferedReader(new FileReader(input)); PrintWriter pw = new PrintWriter(output)){        //resource-ok ;-vel elválasztva
            String currentLine;
            
            while((currentLine = br.readLine()) != null){
                
                //Vigyázz: Az első szám csak szóközzel van elválasztva.
                String[] words = currentLine.split(",| ");        //Regex: vagy szóköz vagy vessző mentén szeletelj.
                int[] numbers = new int[words.length];
                for(int i=0; i<words.length; i++){
                    numbers[i] = Integer.parseInt(words[i]);
                }
                
                boolean foundTwoNumbers=false;
                
                for(int i=1; i<numbers.length; i++){
                    for(int j=i+1; j<numbers.length; j++){
                        if(numbers[i] + numbers[j] == numbers[0]){
                            pw.println(numbers[0] + " " + numbers[i] + " " + numbers[j]);
                            foundTwoNumbers=true;
                        }
                    }
                }

                if(!foundTwoNumbers){
                    pw.println(numbers[0] + " none");
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Filenot found.");
        } catch (IOException e){
            System.out.println("IO error.");
        }
    }
}