//Készítette: Lukács Dávid István
public class Square implements Shape{
    private double a;

    @Override
    public double getPerimeter() {return 4*a;}
    
    @Override
    public double getArea() {return Math.pow(a,2);}

}