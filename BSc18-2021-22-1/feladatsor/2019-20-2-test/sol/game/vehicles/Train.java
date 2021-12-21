package game.vehicles;

import game.vehicles.Vehicle;
import game.utils.VehicleException;


public class Train extends Vehicle
{
    @Override
    public void accelerate(double amount) throws VehicleException
    {
        if (amount < 0)
        {
            super.accelerateCurrentSpeed(amount/10);
        }
        else
        {
            super.accelerateCurrentSpeed(amount);
        }
    }
}

