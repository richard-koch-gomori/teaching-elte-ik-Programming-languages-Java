package game.vehicles;

import game.vehicles.Vehicle;
import game.utils.VehicleException;
import game.Player;


public class Car extends Vehicle implements Comparable<Car>
{
    // 1 pont (adattagok, getter, láthatóság, konstruktor)
    private final int maxSpeed;
    private final int cost;

    // owner adattagra nem adott utasítást a feladat, valahogy le kell kódolni, hogy egy autót pontosan egy játékos vehet meg
    private Player owner;

    public Car(int maxSpeed, int cost)
    {
        this.maxSpeed = maxSpeed;
        this.cost = cost;
        this.owner = null;
    }

    public int getCost()
    {
        return cost;
    }

    public Player getOwner()
    {
        return owner;
    }

    public void setOwner(Player newOwner)
    {
        this.owner = newOwner;
    }

    @Override
    public String toString()
    {
        return this.id + ": max speed: " + maxSpeed + ", cost: " + cost;
    }

    @Override
    public void accelerate(double amount) throws VehicleException
    {
        if (this.getCurrentSpeed() + amount <= maxSpeed) // 1 pont
        {
            super.accelerateCurrentSpeed(amount);
        }
    }

    @Override
    public int compareTo(Car that)
    {
        int compareResult = Integer.compare(this.maxSpeed, that.maxSpeed); // 1 pont

        if (compareResult == 0)
        {
            return Integer.compare(this.cost, that.cost); // 1 pont
        }
        else return compareResult;
    }

/*
    @Override
    public int compareTo(Car that)
    {
        if (this.maxSpeed < that.maxSpeed)
        {
            return -1;
        }
        else if (this.maxSpeed == that.maxSpeed)
        {
            if (this.cost < that.cost)
            {
                return -1;
            }
            else if (this.cost == that.cost)
            {
                return 0;
            }
            else return 1;
        }
        else
        {
            return 1;
        }
    }
*/
}
