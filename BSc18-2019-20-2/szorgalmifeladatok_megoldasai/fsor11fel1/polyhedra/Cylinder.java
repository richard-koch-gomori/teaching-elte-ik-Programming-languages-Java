//Készítette: Lukács Dávid István
package polyhedra;

public class Cylinder extends Prism{
    private Circle base;

    public double baseArea(){
        return Math.pow(base.getR(), 2) * Math.PI;
    }

    public String toString()
    {
        return "h=" + this.height +"r= " + base.getR();
    }
}