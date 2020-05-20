//Készítette: Lukács Dávid István
import java.util.Objects;
public class Circle {
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
    public boolean equals(Object that)
    {
        if(that==null)
        {
            return false;
        }
        if(that instanceof Circle)
        {
            Circle returnable = (Circle)that;
            return this.r == returnable.r;
        }
        else return false;
     }
     public int hashCode(){return Objects.hash(r);}

}
