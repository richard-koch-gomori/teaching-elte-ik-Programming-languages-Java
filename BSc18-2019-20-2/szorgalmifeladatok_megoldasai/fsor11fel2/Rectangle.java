//Készítette: Lukács Dávid István
public class Rectangle implements Shape{
    private double a,b;

    @Override
    public double getPerimeter() {return 2*a + 2*b;}
    
    @Override
    public double getArea() {return a*b;}

}