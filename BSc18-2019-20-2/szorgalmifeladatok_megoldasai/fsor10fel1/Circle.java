//Készítette: Korom Pál Gábor

public class Circle{
    private double x;
    private double y;
    private double radius;
    
    public Circle(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double getRadius(){
        return radius;
    }
    
    @Override
    public boolean equals(Object that){
        if(that == null) return false;
        if(this == that) return true;
        if(that instanceof Circle){
            Circle thatCircle = (Circle) that;
            return this.radius == thatCircle.getRadius();
        }else return false;
    }
    
    @Override
    public int hashCode(){
        return 21 * (int)radius;
    }
}