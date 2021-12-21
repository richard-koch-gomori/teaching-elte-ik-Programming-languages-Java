package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import game.vehicles.Car;
import game.utils.VehicleException;


public class Player
{
    private String name, ip;
    private int money;
    private ArrayList<Car> cars;

    public int getMoney()
    {
        return money;
    }

    public Player(String name, String ip, int money)
    {
        if (name == null || ip == null || ip.length() <= 0 || money < 0)
        {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < ip.length(); ++i)
        {
            if (Character.isWhitespace(ip.charAt(i)))
            {
                throw new IllegalArgumentException();
            }
        }

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
    public boolean equals(Object that)
    {
        if (that == null) return false;
        if (that == this) return true;

        if (that instanceof Player)
        {
            Player thatPlayer = (Player)that;
            return this.name.equals(thatPlayer.name) && this.money == thatPlayer.money && this.cars.equals(thatPlayer.cars);
        }
        else return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, money, cars);
    }

    public void buyCar(Car car) throws VehicleException
    {
        if (money < car.getCost())
        {
            throw new VehicleException("buyCar(): player doesnt have enough money");
        }
        if (car.getOwner() != null)
        {
            throw new VehicleException("buyCar(): car already has an owner");
        }

        car.setOwner(this);
        cars.add(car);
        money -= car.getCost();
    }

    public ArrayList<Car> getSortedCars()
    {
        ArrayList<Car> sortedCars = new ArrayList<Car>(cars);
        Collections.sort(sortedCars);
        return sortedCars;
    }
}

