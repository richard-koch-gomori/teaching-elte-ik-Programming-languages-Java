// Jónás Bendegúz Gergő megoldása

package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import game.Player;
import game.vehicles.Car;
import game.utils.VehicleException;

public class Tests 
{
    public static final double epszilon = 0.001;

    @Test(expected = IllegalArgumentException.class)
    public void PlayerIfNameIsNull()
    {
        new Player(null, "192.168.0.122", 600);
    }

    @Test(expected = IllegalArgumentException.class)
    public void PlayerIfMoneyIsNegative()
    {
        new Player("Bob", "192.168.0.122", -600);
    }

    @Test(expected = IllegalArgumentException.class)
    public void PlayerIfIpHasWhitespace()
    {
        new Player("Bob", "192.168.0. 122", 600);
    }

    @Test
    public void PlayerMoneyIsCorrect()
    {
        Player p = new Player("Bob", "192.168.0.122", 600);
        //assertTrue(p.getMoney() == 600);
        assertEquals(600, p.getMoney());
    }

    @Test
    public void CarAccelerateIsCorrent()
    {
        Car c = new Car(180, 500);
        try
        {
            c.accelerate(90);
            assertEquals(90, c.getCurrentSpeed(), epszilon);
            
            c.accelerate(10);
            assertEquals(100, c.getCurrentSpeed(), epszilon);
        }
        catch(VehicleException e)
        {
            fail();
        }
    }

    @Test
    public void CarPassMaxSpeed()
    {
        Car c = new Car(180, 500);
        try
        {
            c.accelerate(200);
            assertEquals(0, c.getCurrentSpeed(), epszilon);
        }
        catch(VehicleException e)
        {
            fail();
        }
    }

    @Test(expected = VehicleException.class)
    public void CarPassNinimumSpeed() throws VehicleException
    {
        Car c = new Car(180, 500);

        c.accelerate(-199);
        assertEquals(0, c.getCurrentSpeed(), epszilon);
    }

    @Test(expected = VehicleException.class)
    public void PlayerHasNoMoney() throws VehicleException
    {
        Player p = new Player("Bob", "192.168.0.122", 400);
        Car c = new Car(180, 500);

        p.buyCar(c);
    }    

    @Test(expected = VehicleException.class)
    public void CarIsTaken() throws VehicleException
    {
        Player p1 = new Player("Bob", "192.168.0.122", 1000);
        Player p2 = new Player("Bil", "192.168.0.123", 1000);
        Car c = new Car(180, 500);

        p2.buyCar(c);
        p1.buyCar(c);
    }    
}
