//Készítette: Lukács Dávid István
package polyhedra;

public class Cube extends Prism
{
    private double a;

    public double baseArea()
    {
        return Math.pow(a,2);
    }

    public String toString()
    {
        return "h=" + this.height;
    }
}   