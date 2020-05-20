//Készítette: Korom Pál Gábor

public class Rectangle implements Shape{
    private double sideLengthX;
    private double sideLengthY;
    
    public Rectangle(double sideLengthX, double sideLengthY){
        this.sideLengthX = sideLengthX;
        this.sideLengthY = sideLengthY;
    }
    
    public double getPerimeter(){
        return 2*(sideLengthX + sideLengthY);
    }
    
    public double getArea(){
        return sideLengthX * sideLengthY;
    }
}