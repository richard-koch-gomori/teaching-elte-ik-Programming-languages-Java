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

    public boolean equals(Circle that){
        if(that==null)
        {
            return false;
        }
        return this.r == that.r;}
        public int hashCode(){return Objects.hash(r);}

}