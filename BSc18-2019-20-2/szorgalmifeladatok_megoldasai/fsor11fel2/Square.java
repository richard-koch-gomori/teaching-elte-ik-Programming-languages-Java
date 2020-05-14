//Készítette: Korom Pál Gábor

public class Square implements Shape{
    private double sideLength;
    
    public Square(double sideLength){
        this.sideLength = sideLength;
    }
    
    public double getPerimeter(){
        return 4 * sideLength;
    }
    
    public double getArea(){
        return sideLength * sideLength;
    }
}