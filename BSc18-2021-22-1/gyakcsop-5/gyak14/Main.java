/*
Írjon `LightBulb` osztályt, mellyel egy karácsonyfa égősor egy égőjét reprezentálunk.
Egy égőről tároljuk, hogy hány voltos (`voltage`), hány wattos (`watt`) valamint a
színét (`color`). A színre hozzunk létre egy felsorolt típust, melynek elemei:
`WHITE`, `RED`, `BLUE`, `GREEN`, `YELLOW`

Írjon `equals()` és `hashCode()` metódusokat, melyek megfelelnek a
"szerződésben foglalt" elvárásoknak.
Az `equals()` metódus NE vegye figyelembe
egy égő színét: az égőknél gyakori, hogy a szín nem érdekel minket, azonban pl.
egy 14V, 3W-os égő nem lesz kompatibilis egy 14V, 5W-os égővel.

Mutassa be egy főprogramban, hogy 3 példányosított égő esetén az egyik égőre
teljesül az egyenlőség, egy másikra pedig nem.
*/

import java.util.Objects;
import java.util.HashSet;

enum Color { WHITE, RED, BLUE, GREEN, YELLOW };

class LightBulb
{
    private int voltage, watt;
    private Color color;

    public LightBulb(int voltage, int watt, Color color)
    {
        this.voltage = voltage;
        this.watt = watt;
        this.color = color;
    }

    @Override
    public boolean equals(Object that)
    {
        if (that == this) return true;
        if (that == null) return false;

        if (that instanceof LightBulb)
        {
            LightBulb thatLightBulb = (LightBulb)that;
            return voltage == thatLightBulb.voltage && watt == thatLightBulb.watt;
        }
        else return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(voltage, watt);
    }

    @Override
    public String toString()
    {
        return voltage + "V; " + watt + "W";
    }
}

class Main
{
    public static void main(String[] args)
    {
        LightBulb light1 = new LightBulb(14, 3, Color.WHITE);
        LightBulb light2 = new LightBulb(14, 3, Color.BLUE);
        LightBulb light3 = new LightBulb(14, 5, Color.YELLOW);

        System.out.println(light1.equals(light2));
        System.out.println(light1.equals(light3));

        HashSet<LightBulb> set = new HashSet<>();
        set.add(light1);
        set.add(light2);
        set.add(light3);
        System.out.println(set);
    }
}
