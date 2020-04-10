// Készítette: Lukács Dávid István

package game;

import game.utils.Vehicle;

public class Player
{
private String Name,ip;
private int hp;
private Vehicle car;

public Player(String regname, String regip)
{
    Name=regname;
    ip=regip;
    car=null;
    hp=100;
}

public String toString()
{
    if(car!=null)
    {
    return "name: " + Name + " ip adress: " + ip + "HP: " + hp + " car's license number:" + car.getLp();
    }
    else{
        return "name: " + Name + " ip adress: " + ip + "HP: " + hp;
    }
}

public void BuyCar(Vehicle newride)
{
    car=newride;
}

}