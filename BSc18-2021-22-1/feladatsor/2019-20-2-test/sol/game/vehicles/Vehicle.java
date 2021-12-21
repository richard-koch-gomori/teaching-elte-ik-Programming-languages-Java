package game.vehicles;

import game.utils.VehicleException;


public abstract class Vehicle
{
    private static int currentId = 0;
    protected final int id;
    private double currentSpeed;

    public double getCurrentSpeed()
    {
        return currentSpeed;
    }

    protected Vehicle()
    {
        this.id = currentId++;
    }

    protected final void accelerateCurrentSpeed(double amount) throws VehicleException
    {
        if (currentSpeed + amount < 0) 
        {
            throw new VehicleException("accelerate(): invalid amount");
        }
        currentSpeed += amount;
    }

    public abstract void accelerate(double amount) throws VehicleException;
}

