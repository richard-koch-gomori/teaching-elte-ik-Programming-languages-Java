

package circle;

import circle.utils.Point;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Circle
{
    private Point center;
    private double radius = 1;

    public Circle(Point center, double init_radius)
    {
        // ennek hatására csak a referencia másolódik, így a Circle objektumok
        // ugyanazt a center objektumot érik el
        //this.center = center;
        
        // így már jó: a Circle saját másolattal rendelkezik
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

    // visszaadja a kör középpontját Point típusú adatban
    public Point getCenter()
    {
        // a Point kiszivárogtatja az obj. belső állapotát,
        // mert a felhasználó kód "el tudja rontani" a Circle belső állapotát
        // (belső adattagjainak értékeit)
        //return center;

        // így már jó: a felhasználó kód egy saját másolatot kap
        return new Point(center);
    }

    public static Circle readFromFile(String filename)
    {
        File file = new File(filename);

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            double x = Double.parseDouble(br.readLine());
            double y = Double.parseDouble(br.readLine());
            double radius = Double.parseDouble(br.readLine());
            br.close();
            return new Circle(new Point(x, y), radius);
        }
        catch (FileNotFoundException exc)
        {
            System.out.println("Unable to open file: " + filename);
        }
        catch (IOException exc)
        {
            System.out.println("IO error occured");
        }
        return new Circle(new Point(0, 0), 1);
    }
}


