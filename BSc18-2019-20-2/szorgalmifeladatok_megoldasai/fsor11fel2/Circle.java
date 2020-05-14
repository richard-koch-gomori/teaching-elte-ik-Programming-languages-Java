//Készítette: Korom Pál Gábor

public class Circle implements Shape{
    private double x;
    private double y;
    private double radius;
    
    public Circle(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    public double getPerimeter(){
        return 2 * radius * Math.PI;
    }
    
    public double getArea(){
        return radius * radius * Math.PI;
    }
}