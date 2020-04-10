// Készítette: Lukács Dávid István
package game.utils;

public class  Vehicle {
private int modelid;
private String lp;
private int color1,color2;

public Vehicle(int model, int c1, int c2)
{
    modelid=model;
    color1=c1;
    color2=c2;
}

public String getLp()
{
    return lp;
}
public void setLp(String licensenumber)
{
    lp=licensenumber;
}

}