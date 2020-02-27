

package circle;

import circle.utils.Point;


public class Main
{
    public static void main(String[] args)
    {
        Circle c = new Circle();

        // a user code-nak tudnia kell, hogy a Circle objektum létrehozása után, annak a center adattagját még inicializálni kell
        // így a Circle osztályt könnyű rosszul használni -> megoldás: legyen Circle-nek konstruktora, és a konstruktor végezze a szükséges inicializálásokat (ld fel5)
        c.center = new Point();

        // az sem jó, hogy az adattagokhoz is kilátszanak az osztályból, a felhasználó könnyen elronthatja
        // az adattagokhoz csak spcieális (setter és getter) metódusok férjenek hozzá (ld fel5)
        c.center.x = 1;
        c.center.y = 2;
        c.radius = 5;
        c.enlarge(10);
        System.out.println("area: " + c.getArea());
        System.out.println(c.toString());
    }
}
