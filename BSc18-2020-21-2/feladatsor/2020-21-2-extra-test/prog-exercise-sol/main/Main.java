package main;

import game.Server;
import game.Player;
import util.Cipher;
import util.ServerException;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main
{
    public static final int shift = 3; // 0.5 pont

    public static void main(String[] args)
    {
        Server server = new Server(); // 0.5 pont

        while (true)
        {
            System.out.print("Enter name: ");
            String name = System.console().readLine();

            File user = new File("users/" + name + ".txt");
            try (BufferedReader br = new BufferedReader(new FileReader(user)))
            {
                System.out.print("Enter password: "); // 0.5 pont
                String password = System.console().readLine();
                String encryptedPassword = Cipher.encrypt(password, shift); // 0.5 pont
                String ipAddress = br.readLine();
                String encryptedPasswordFromFile = br.readLine(); // 0.5 pont
                if (encryptedPassword.equals(encryptedPasswordFromFile)) // 0.5 pont
                {
                    server.addParticipant(new Player(name, ipAddress)); // 0.5 pont
                    System.out.println("Login success!"); // 0.5 pont
                }
                else
                {
                    System.out.println("Login failed! Incorrent password."); // 0.5 pont
                }
            }
            catch (FileNotFoundException exc)
            {
                System.out.println("Name " + name + " is not registered!"); // 0.5 pont
                System.out.println();
            }
            catch (IOException exc)
            {
                System.out.println("Error: IO error occured: " + exc.getMessage());
            }
            catch (ServerException exc)
            {
                System.out.println("Server error occured: " + exc.getMessage()); // 0.5 pont
            }

            System.out.println("Participants on the server: ");
            System.out.println(server + System.lineSeparator()); // 0.5 pont
        }
    }
}

