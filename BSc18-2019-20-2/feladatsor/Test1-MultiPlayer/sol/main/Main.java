package main;

import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import game.Player;
import game.vehicles.Vehicle;
import game.vehicles.Train;
import game.vehicles.Car;
import game.utils.VehicleException;


public class Main
{
    public static Player loadPlayerFromFile(String playerName) // 0.5 pont hibánként, összesen 2 pont
    {
        File input = new File("users/" + playerName + ".txt");

        String[] data = null; // tömb []
        try (BufferedReader bf = new BufferedReader(new FileReader(input)))
        {
            String line = bf.readLine();
            data = line.split(" ");

            return new Player(playerName, data[0], Integer.parseInt(data[1])); // parse és kiindexelés
        }
        catch (IOException e)
        {
            System.out.println("IO error occured: " + e.getMessage());
        }
        catch (NumberFormatException e)
        {
            return new Player(playerName, data[0], 0); // itt is kell konstruálni
        }

        return null;
    }

    public static void main(String[] args) // 1 pont
    {
        Player Daniel = loadPlayerFromFile("Daniel");

        loadPlayerFromFile("Peter");
        loadPlayerFromFile("Richard");
        loadPlayerFromFile("Tamas");
        loadPlayerFromFile("Zorror");

        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(200, 9000));
        cars.add(new Car(200, 10000));
        cars.add(new Car(150, 5000));
        cars.add(new Car(300, 20000));
        cars.add(new Car(300, 22000));
        cars.add(new Car(300, 20000));
        cars.add(new Car(200, 30000));

        try
        {
            Daniel.buyCar(cars.get(2));
            Daniel.buyCar(cars.get(3));
            Daniel.buyCar(cars.get(4));
            Daniel.buyCar(cars.get(6));

            System.out.println("Daniel's cars: " + Daniel.getSortedCars());
        }
        catch (VehicleException e)
        {
            System.out.println(e.getMessage());
        }
    }
}

