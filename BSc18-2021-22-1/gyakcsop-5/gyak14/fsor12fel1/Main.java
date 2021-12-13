
import java.util.HashSet;
import java.util.Objects;

/*
class Object
{
    public boolean equals(Object that)
    {
        // ugyanaz a memóriacím-e
        return this == that;
    }
}
*/

/*
Az equals() és hashCode() szerződése:
- equals() az egy ekvivalenciareláció: reflexív, szimmetrikus, tranzitív
- ha a.equals(b) igaz, akkor a.hashCode() == b.hashCode()

[meg. jó lenne, ideális ha a.equals(b)==false esetén a.hashCode() != b.hashCode(); ez utóbbit teljesíteni viszont nagyon nehéz]
*/

class DoubleVector
{
    double[] coords;

    public DoubleVector(double x1, double x2)
    {
        this.coords = new double[2];
        this.coords[0] = x1;
        this.coords[1] = x2;
    }

    @Override
    public boolean equals(Object that)
    {
        if (that == this) return true;
        if (that == null) return false;

        if (that instanceof DoubleVector)
        {
            DoubleVector thatVector = (DoubleVector)that;
            return thatVector.coords[0] == this.coords[0] && thatVector.coords[1] == this.coords[1];
        }
        else return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.coords[0], this.coords[1]);
    }

    public String toString()
    {
        return "(" + this.coords[0] + "," + this.coords[1] + ")";
    }
}

class Main
{
    public static void main(String[] args)
    {
        System.out.println(new DoubleVector(2, 3).equals(new DoubleVector(2, 3)));
        System.out.println(new DoubleVector(2, 3).equals(new DoubleVector(2, 2)));

        HashSet<DoubleVector> exampleSet = new HashSet<DoubleVector>();
        exampleSet.add(new DoubleVector(0, 0));
        exampleSet.add(new DoubleVector(3, -7));
        exampleSet.add(new DoubleVector(3, -7));
        System.out.println( "size of HashSet: " + exampleSet.size());
        System.out.println( "items of HashSet: " + exampleSet);
    }
}

/*
pl. teszteljük le, h tranzitív-e

a.equals(b) és b.equals(c) akkor a.equals(c)

DoubleVector a = new DoubleVector(2, 3);
DoubleVector b = new DoubleVector(2, 3);
DoubleVector c = new DoubleVector(2, 3);
assertTrue(a.equals(b));
assertTrue(b.equals(c));
assertTrue(a.equals(c));
*/