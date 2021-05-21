// Jónás Bendegúz Gergő megoldása

package game.vehicles;

import game.utils.*;
import game.Player;

public class Car extends Vehicle
{
    private final int maxSpeed;
    private final int cost;
    private Player owner = null;

    public Car(int maxSpeed, int cost)
    {
        this.maxSpeed = maxSpeed;
        this.cost = cost;
    }

    public String toString()
    {
        return id + ": " + maxSpeed + " " + cost;
    }

    @Override
    public void accelerate(double amount) throws VehicleException
    {
        if (getCurrentSpeed() + amount <= maxSpeed) accelerateCurrentSpeed(amount);
    }

    public int getCost()
    {
        return cost;
    }

    public Player getOwner()
    {
        return owner;
    }

    public void setOwner(Player owner)
    {
        this.owner = owner;
    }
}
