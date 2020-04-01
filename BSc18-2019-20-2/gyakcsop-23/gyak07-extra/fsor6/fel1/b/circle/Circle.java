

package circle;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import circle.utils.*;


public class Circle
{
    private Point center;
    private double radius;
    private String label;

    // a körök neve defaultLabel-el inicializálódjon, ha konstruáláskor null-al hívják meg a konstruktort
    // ez az alap kezdőérték nyilván nem egy konkrét Circle objektumhoz tartozik, hanem az összes Circle objektumhoz tartozik
    // tehát ezt ésszerű osztályszintű (statikus) adattaggá tenni
    // final kulcsszó: a deklarált változó nem szerepelhet az értékadás bal oldalán (kivétel adattag esetén a konstruktorban, de erről később)
    private static final String defaultLabel = "unnamed";

    // saját setter írása: itt pl hasznos, mert az új értékekre ellenőrzéseket tud csinálni,
    // értelmetlen adat esetén nem állítja be az adattagokat
    public void setRadius(double radius)
    {
        if (radius <= 0)
        {
            throw new IllegalArgumentException();
        }
        this.radius = radius;
    }

    public Circle(Point center, double radius, String label)
    {
        // this.center = center; // csak a center objektum referenciáját teszi el
        this.center = new Point(center); // így viszont készítünk egy saját másolatot
        this.radius = radius;

        if (label == null)
        {
            this.label = defaultLabel;
        }
        else
        {
            this.label = label;
        }
    }

    public Circle(double x, double y, double radius, String label)
    {
        // a Circle(Point center, double radius, String label) konstruktor hívása
        this(new Point(x, y), radius, label);
    }

    public void enlarge(double f)
    {
        radius *= f;
    }

    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    public String toString()
    {
        return label + ":(" + center.getX() + "," + center.getY() + "), r = " + radius;
    }

    public static Circle readFromFile(String filename)
    {
        Circle result = null;
        File input = new File(filename);

        try (BufferedReader br = new BufferedReader(new FileReader(input)))
        {
            double x = Double.parseDouble(br.readLine());
            double y = Double.parseDouble(br.readLine());
            double radius = Double.parseDouble(br.readLine());
            String label = br.readLine();

            result = new Circle(x, y, radius, label);
        }
        catch (IOException | NumberFormatException e)
        {
            result = new Circle(0, 0, 0, null);
        }

        return result;
    }

    public void saveToFile(String filename) throws FileNotFoundException
    {
        File output = new File(filename);

        // try-with-resources
        try (PrintWriter pw = new PrintWriter(output))
        {
            pw.println(center.getX());
            pw.println(center.getY());
            pw.println(radius);
            pw.println(label);
        }
    }
}


/*
ellenőrzött kivételek
pl FileNotFoundException
ált. futási időben kijavíthatóak

nem ellenőrzött kivételek
pl IllegalArgumentException, ArithmeticException, tömb kiindexelés
 - RuntimeException
 - Error



*/

