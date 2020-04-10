// Készítette: Lukács Dávid István
package game;

import game.utils.Vehicle;
public class Main{

    public static void main(final String[] args)
    {
    Vehicle car1 = new Vehicle(171,255,255);
    Vehicle car2 = new Vehicle(150,128,128);  
    Vehicle car3 = new Vehicle(130,128,128);
    car1.setLp("NSX277");
    car2.setLp("NDM678");
    car3.setLp("NTV171");
    Player me = new Player("David","192.168.1.1");
    final Player mom = new Player("Eva","192.168.1.2");
    me.BuyCar(car1);
    System.out.println(me.toString());
    System.out.println(mom.toString());
    }
}