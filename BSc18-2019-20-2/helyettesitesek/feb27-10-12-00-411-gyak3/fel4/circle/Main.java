
package circle;


public class Main
{
    public static void main(String[] args)
    {
        Circle c1 = new Circle();

        // a user code-nak tudnia kell, hogy a Circle objektum létrehozása után, annak a center adattagját még inicializálni kell
        // így a Circle osztályt könnyű rosszul használni -> megoldás: legyen Circle-nek konstruktora, és a konstruktor végezze a szükséges inicializálásokat (ld fel5)
        c1.center = new circle.utils.Point();

        // az sem jó, hogy az adattagokhoz is kilátszanak az osztályból, a felhasználó könnyen elronthatja
        // az adattagokhoz csak spcieális (setter és getter) metódusok férjenek hozzá (ld fel5)
        c1.center.x = 1;
        c1.center.y = 2;
        c1.radius = 10;
        System.out.println(c1.toString());
        c1.enlarge(3);
        System.out.println(c1);
    }
}

