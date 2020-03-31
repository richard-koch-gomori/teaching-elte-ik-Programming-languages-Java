

package circle;

import circle.utils.Point;


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

    public void setRadius(double radius)
    {
        // saját setter írása: itt pl hasznos, mert az új értékekre ellenőrzéseket tud csinálni,
        // értelmetlen adat esetén nem állítja be az adattagokat
        if (radius < 0)
        {
            throw new IllegalArgumentException();
        }
        this.radius = radius;
    }

    public Circle(Point center, double radius, String label)
    {
        // this.center = center; // csak a center objektum referenciáját teszi el
        this.center = new Point(center); // így viszont készítünk egy saját másolatot

        // ezzel ugyanazt érjük el:
        //this.center = new Point();
        //this.center.setX(center.getX());
        //this.center.setY(center.getY());

        this.radius = radius;
        if (label == null)
            this.label = defaultLabel;
        else
            this.label = label;
    }

    public Circle(double x, double y, double radius, String label)
    {
        // a Circle(Point center, double radius, String label) konstruktor hívása
        this(new Point(x, y), radius, label);
    }

    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    public void enlarge(double f)
    {
        radius = f * radius;
    }

    public String toString()
    {
        return label + ": (" + center.getX() + "," + center.getY() + "), r = " + radius;
    }
}

