//Készítette: Lukács Dávid István
public class Circle implements Shape{
    private double x,y,r;
    public Circle(double _x,double _y, double _r)
    {
        x=_x;
        y=_y; 
        r=_r;
    }
    public double getX(){return x;}
    public double getY(){return y;}
    public double getR(){return r;}
    
    @Override
    public double getArea() {return Math.pow(r, 2)*Math.PI;}

    @Override
    public double getPerimeter() {return 2*r*Math.PI;}
}