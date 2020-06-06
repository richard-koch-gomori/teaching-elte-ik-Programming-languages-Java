package game.vehicles;

import game.utils.VehicleException;


public abstract class Vehicle
{
    // 1 pont (adattagok, getter, láthatóság, konstruktor)
    private static int currentId = 0;
    protected final int id;
    private double currentSpeed;

    public double getCurrentSpeed()
    {
        return currentSpeed;
    }

    protected Vehicle()
    {
        this.id = currentId++; // 1 pont
    }

    protected final void accelerateCurrentSpeed(double amount) throws VehicleException
    {
        if (currentSpeed + amount < 0) // 1 pont
        {
            throw new VehicleException("accelerate(): invalid amount");
        }
        currentSpeed += amount;
    }

    public abstract void accelerate(double amount) throws VehicleException; // 1 pont
}

