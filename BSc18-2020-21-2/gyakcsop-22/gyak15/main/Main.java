// Jónás Bendegúz Gergő megoldása

package main;

import java.io.*;
import game.Player;

class Main
{
    public static Player loadPlayerFromFile(String playerName){
        File input = new File("users/" + playerName + ".txt");

        String[] data = null;
        try (BufferedReader bf = new BufferedReader(new FileReader(input))){
            String line = bf.readLine();
            data = line.split(" ");

            return new Player(playerName, data[0], Integer.parseInt(data[1]));
        } catch (IOException e) {
            System.out.println("IO error occured: " + e.getMessage());
        } catch (NumberFormatException e) {
            return new Player(playerName, data[0], 0);
        }

        return null;
    }

    public static void main(String[] args)
    {
        Player Daniel = loadPlayerFromFile("Daniel");
        Player Peter = loadPlayerFromFile("Peter");
        Player Richard = loadPlayerFromFile("Richard");
        Player Tamas = loadPlayerFromFile("Tamas");
        Player Zorror = loadPlayerFromFile("Zorror");
    }   
}
