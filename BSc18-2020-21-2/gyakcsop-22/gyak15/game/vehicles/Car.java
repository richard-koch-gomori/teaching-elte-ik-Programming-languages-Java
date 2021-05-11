// Jónás Bendegúz Gergő megoldása

package game.vehicles;

import game.utils.*;

public class Car extends Vehicle
{
    private final int maxSpeed;
    private final int cost;

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
        if (currentSpeed + amount <= maxSpeed) accelerateCurrentSpeed(amount);
    }
}
