// Jónás Bendegúz Gergő megoldása

package game.vehicles;

import game.utils.*;

public abstract class Vehicle
{
    protected final int id;
    private static int counter = 0;
    private double currentSpeed;

    public Vehicle()
    {
        id = counter++;
    }

    public double getCurrentSpeed()
    {
        return currentSpeed;
    }

    protected final void accelerateCurrentSpeed(double amount) throws VehicleException
    {
        if(currentSpeed + amount < 0) throw new VehicleException("Invalid amount!");
        currentSpeed += amount;
    }

    abstract public void accelerate(double amount) throws VehicleException;
}
