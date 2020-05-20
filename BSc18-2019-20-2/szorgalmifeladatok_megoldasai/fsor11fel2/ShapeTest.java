//Készítette: Korom Pál Gábor

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ShapeTest{
    
    @Test
    public void Shape_interface_methods(){
        Square square = new Square(5);
        Rectangle rectangle = new Rectangle(4,8);
        Circle circle = new Circle(4,5,10);
        
        assertEquals(square.getPerimeter(),20,0.001);
        assertEquals(square.getArea(),25,0.001);
        assertEquals(rectangle.getPerimeter(),24,0.001);
        assertEquals(rectangle.getArea(),32,0.001);
        assertEquals(circle.getPerimeter(),20*Math.PI,0.001);
        assertEquals(circle.getArea(),100*Math.PI,0.001);
    }
}