

package circle;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

import circle.utils.Point;


public class Circle
{
    private Point center;
    private double radius;
    private String label;

    private static final String defaultLabel = "unnamed";

    public void setRadius(double radius)
    {
        if (radius < 0)
        {
            throw new IllegalArgumentException();
        }
        this.radius = radius;
    }

    public Circle(Point center, double radius, String label)
    {
        this.center = new Point(center);

        this.radius = radius;
        if (label == null)
            this.label = defaultLabel;
        else
            this.label = label;
    }

    public Circle(double x, double y, double radius, String label)
    {
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

    // ez a függvény nem engedi kiszökni a IOException és NumberFormatException kivételeket
    // ha ilyen kivételek fellépnek, akkor is (fiktív körülmények miatt) létre kell hozni
    // egy Circle objektumot csupa 0-szerű értékekkel
    public static Circle readFromFile(String filename)
    {
        File input = new File(filename);
        Circle result = null;

        try (BufferedReader br = new BufferedReader(new FileReader(input)))
        {
            double x = Double.parseDouble(br.readLine());
            double y = Double.parseDouble(br.readLine());
            double radius = Double.parseDouble(br.readLine());
            String label = br.readLine();
            result = new Circle(x, y, radius, label);
        }
        // több kivétel esetén ugyanaz történjen
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
        // a try () zárójelében lefoglalt olvasó objektumok close() metódusa meghívódik
        // a try{} blokk végrehajtása után
    }
}

