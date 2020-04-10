//készítette: Lukács Dávid István
package auto;
import auto.utils.Color;


public class Auto
{
private String licensenumber; 
private Color color;
private int topspeed;
private static int created;

public Auto()
{
   licensenumber="AAA-000";
   color=Color.BLUE;
   topspeed=120;
   created++;
}

public Auto(String l,String c, int t)
{
   licensenumber=l;
   color=Color.valueOf(c);
   topspeed=t;
   created++;
}

public boolean equals(Auto that)
{
   return (that.topspeed<this.topspeed);
}

public String toString()
{
   return ""+licensenumber + "," + color + "," + topspeed + "," + created;
}

}