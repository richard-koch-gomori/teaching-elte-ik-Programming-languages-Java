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
    public static final int shift = 3;

    public static void main(String[] args)
    {
        Server server = new Server();

        while (true)
        {
            System.out.print("Enter name: ");
            String name = System.console().readLine();

            File user = new File("users/" + name + ".txt");
            try (BufferedReader br = new BufferedReader(new FileReader(user)))
            {
                System.out.print("Enter password: ");
                String password = System.console().readLine();
                String encryptedPassword = Cipher.encrypt(password, shift);
                String ipAddress = br.readLine();
                String encryptedPasswordFromFile = br.readLine();
                if (encryptedPassword.equals(encryptedPasswordFromFile))
                {
                    server.addParticipant(new Player(name, ipAddress));
                    System.out.println("Login success!");
                }
                else
                {
                    System.out.println("Login failed! Incorrent password.");
                }
            }
            catch (FileNotFoundException exc)
            {
                System.out.println("Name " + name + " is not registered!");
                System.out.println();
            }
            catch (IOException exc)
            {
                System.out.println("Error: IO error occured: " + exc.getMessage());
            }
            catch (ServerException exc)
            {
                System.out.println("Server error occured: " + exc.getMessage());
            }

            System.out.println("Participants on the server: ");
            System.out.println(server + System.lineSeparator());
        }
    }
}

