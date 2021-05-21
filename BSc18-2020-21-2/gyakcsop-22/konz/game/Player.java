// Jónás Bendegúz Gergő megoldása

package game;

import java.util.ArrayList;
import game.vehicles.*;
import game.utils.*;

public class Player
{
    private String name;
    private String ip;
    private int money;
    private ArrayList<Car> cars;

    public Player(String name, String ip, int money)
    {
        if(name == null || ip == null || ip.length() <= 0 || money < 0) throw new IllegalArgumentException();

        for(int i = 0; i < ip.length(); i++)
        {
            if(Character.isWhitespace(ip.charAt(i))) throw new IllegalArgumentException();
        }

        this.name = name;
        this.ip = ip;
        this.money = money;
        cars = new ArrayList<>();
    }

    public int getMoney()
    {
        return money;
    }

    public void buyCar(Car c) throws VehicleException
    {
        if(c.getOwner() != null) throw new VehicleException("Already taken.");

        if(money >= c.getCost())
        {
            cars.add(c);
            money -= c.getCost();
            c.setOwner(this);
        }
        else
        {
            throw new VehicleException("No money.");
        }
    }

    public ArrayList<Car> getCars()
    {
        return new ArrayList<Car> (cars);
    }
}
