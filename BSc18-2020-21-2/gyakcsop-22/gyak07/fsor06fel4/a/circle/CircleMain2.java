package circle;

import java.io.*;

import circle.utils.Point;


public class CircleMain2
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        Circle c = new Circle(5, 2, 10);
        System.out.println("area = " + c.getArea());
        Point center = c.getCenter();
        System.out.println("center: x = " + center.getX() + ", y = " + center.getY());
        
        Circle c2 = null;
        c2 = Circle.readFromFile("circle/in.txt");
        c.saveToFile("circle/out.txt");

        System.out.println(c2);
    }
}


// stack trace:
// ha egy kivétel kiszökik a main() függvényből, akkor a program futása leáll,
// és a futtató környzet kiírja a képernyőre azt a függvényhívási láncot, amelyen a kivétel
// terjedt, kezdve azzal a ponttal, ahol a kivételt dobták (kiváltották)
/*
area = 314.1592653589793
center: x = 5.0, y = 2.0
Exception in thread "main" java.io.FileNotFoundException: circle/in.txt (Nincs ilyen fájl vagy könyvtár)
	at java.base/java.io.FileInputStream.open0(Native Method)
	at java.base/java.io.FileInputStream.open(FileInputStream.java:219)
	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:157)
	at java.base/java.io.FileInputStream.<init>(FileInputStream.java:112)
	at java.base/java.io.FileReader.<init>(FileReader.java:60)
	at circle.Circle.readFromFile(Circle.java:21)
	at circle.CircleMain2.main(CircleMain2.java:18)*/


