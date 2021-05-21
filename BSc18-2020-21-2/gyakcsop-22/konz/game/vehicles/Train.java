// Jónás Bendegúz Gergő megoldása

package game.vehicles;

public class Train extends Vehicle
{
    @Override
    public void accelerate(double amount)
    {
        if(amount < 0) accelerateCurrentSpeed(amount / 10);
        else accelerateCurrentSpeed(amount);
    }
}
