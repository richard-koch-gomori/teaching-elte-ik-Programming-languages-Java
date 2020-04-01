

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

    public static Circle readFromFile(String filename) throws FileNotFoundException, IOException
    {
        File input = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(input));

        double x = Double.parseDouble(br.readLine());
        double y = Double.parseDouble(br.readLine());
        double radius = Double.parseDouble(br.readLine());
        String label = br.readLine();

        br.close();

        return new Circle(x, y, radius, label);
    }

    public void saveToFile(String filename) throws FileNotFoundException
    {
        File output = new File(filename);
        PrintWriter pw = new PrintWriter(output);

        pw.println(center.getX());
        pw.println(center.getY());
        pw.println(radius);
        pw.println(label);

        pw.close();
    }
}

/*
ellenőrzött kivételek
pl FileNotFoundException

nem ellenőrzött kivétel
pl IllegalArgumentException, ArithmeticException
 - RuntimeException
 - Error
*/

