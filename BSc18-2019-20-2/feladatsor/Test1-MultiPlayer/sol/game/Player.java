package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import game.vehicles.Car;
import game.utils.VehicleException;


public class Player
{
    // 1 pont (adattagok, getter, láthatóság)
    private String name, ip;
    private int money;
    private ArrayList<Car> cars;

    public int getMoney()
    {
        return money;
    }

    public Player(String name, String ip, int money)
    {
        if (name == null || ip == null || ip.length() <= 0 || money < 0) // 1 pont
        {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < ip.length(); ++i)
        {
            if (Character.isWhitespace(ip.charAt(i))) // 1 pont
            {
                throw new IllegalArgumentException();
            }
        }

        // 1 pont
        this.name = name;
        this.ip = ip;
        this.money = money;
        this.cars = new ArrayList<Car>();
    }

    @Override
    public String toString()
    {
        return name + ": " + ip + ", money: " + money;
    }

    @Override
    public boolean equals(Object that) // 0.5 pont
    {
        if (that == null) return false;
        if (that == this) return true;

        if (that instanceof Player) // 1 pont
        {
            Player thatPlayer = (Player)that;
            return this.name.equals(thatPlayer.name) && this.money == thatPlayer.money && this.cars.equals(thatPlayer.cars); // 1 pont
        }
        else return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, money, cars); // 1 pont
    }

    public void buyCar(Car car) throws VehicleException
    {
        if (money < car.getCost()) // 0.5 pont
        {
            throw new VehicleException("buyCar(): player doesnt have enough money");
        }
        if (car.getOwner() != null) // 0.5 pont
        {
            throw new VehicleException("buyCar(): car already has an owner");
        }

        // 1 pont
        car.setOwner(this);
        cars.add(car);
        money -= car.getCost();
    }

    public ArrayList<Car> getSortedCars()
    {
        ArrayList<Car> sortedCars = new ArrayList<Car>(cars); // 1 pont
        Collections.sort(sortedCars);
        return sortedCars;
    }
}

