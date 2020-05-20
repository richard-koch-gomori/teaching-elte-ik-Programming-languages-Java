//Készítette: Lukács Dávid István
package polyhedra;
public abstract class Prism
{
    protected double height;
    public abstract double baseArea();
    public double volume() { return (this.baseArea() * height);}
    public abstract String toString();
}
