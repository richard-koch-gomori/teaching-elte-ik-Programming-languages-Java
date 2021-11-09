

package circle;

import circle.utils.Point;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class Circle
{
    private Point center;
    private double radius = 1;

    public Circle(Point center, double init_radius)
    {
        this.center = new Point(center);

        if (init_radius <= 0)
        {
            System.out.println("radius must be pos");
            System.exit(1);
        }
        radius = init_radius;
    }

    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    public String toString()
    {
        return "(" + center.getX() + "," + center.getY() + "), r = " + radius;
    }

    public Point getCenter()
    {
        return new Point(center);
    }

    // a függvény a fájlkezelő utasítások kivételeit nem kapja el (nincs try-catch blokkban)
    // -> a fellépő kivételeket továbbengedi a hívóhoz
    // a throws kulcsszó után fel kell tüntetni, hogy a függvény milyen (ellenőrzött) kivételeket dobhat
    public static Circle readFromFile(String filename) throws FileNotFoundException, IOException
    {
        // try-with-resources
        File file = new File(filename);
        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            double x = Double.parseDouble(br.readLine());
            double y = Double.parseDouble(br.readLine());
            double radius = Double.parseDouble(br.readLine());
            return new Circle(new Point(x, y), radius);
        }
        // a try () zárójelében lefoglalt erőforrások (resources) close() metódusa meghívódik
        // a try{} blokk végrehajtása után
    }

    public void saveToFile(String filename)
    {
        File file = new File(filename);

        PrintWriter pw = null;
        try
        {
            pw = new PrintWriter(file);
            pw.println(center.getX());
            pw.println(center.getY());
        }
        catch (FileNotFoundException exc)
        {
        }
        finally
        {
            pw.close();
        }
    }
}


