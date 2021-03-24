// kivételknek 2 típusa van:
// - ellenőrzött kivétel: a függvények szignatúráján a throws kulcsszó után fel kell sorolni (deklarálni), ha a függvény dobhat ilyen kivételt
// - nem ellenőrzött kivétel: a függvények szignatúráján a throws kulcsszó után NEM kell felsorolni, ha a függvény dobhat ilyen kivételt

// az ellenőrzött kivételek esetében 2 megközelítési lehetőségünk van:
// - vagy deklaráljuk, hogy a függvényünk dobhat ilyen kivételt
// - vagy nem deklaráljuk, ez esetben viszont try-catch utasítással el kell kapni

package circle;

import circle.utils.Point;
import java.io.*;



public class Circle
{
    private double x;
    private double y;
    private double radius;

    // a függvény a fájlkezelő utasítások kivételeit nem kapja el (nincs try-catch blokkban)
    // -> a fellépő kivételeket továbbengedi a hívóhoz
    // a throws kulcsszó után fel kell tüntetni, hogy a függvény milyen (ellenőrzött) kivételeket dobhat
    public static Circle readFromFile(String filename) throws FileNotFoundException, IOException
    {
        File input = new File(filename);
        BufferedReader br = new BufferedReader(new FileReader(filename));
        double x = Double.parseDouble(br.readLine());
        double y = Double.parseDouble(br.readLine());
        double r = Double.parseDouble(br.readLine());
        Circle ret = new Circle(x,y,r);
        return ret;
    }

    public void saveToFile(String filename) throws FileNotFoundException
    {
        File output = new File(filename);

        // try-with-resources
        try(PrintWriter pw = new PrintWriter(output))
        {
            pw.println(this.x);
            pw.println(this.y);
            pw.println(this.radius);
        }
        // a try () zárójelében lefoglalt erőforrások (resources) close() metódusa meghívódik
        // a try{} blokk végrehajtása után
    }

    public Circle(double init_x, double init_y, double init_radius)
    {
        x = init_x;
        y = init_y;
        radius = init_radius;
    }

    public String toString(){
        return x+", "+y+" r= "+radius;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getRadius()
    {
        return radius;
    }

    public double getArea()
    {
        return Math.pow(radius, 2) * Math.PI;
    }

    public Point getCenter()
    {
        Point center = new Point(x, y);
        return center;
    }
}

/*
ELLENŐRZÖTT KIVÉTELEK
a compiler fordítási időben ellenőrzi, hogy a függvények szignatúráján a throws kulcsszó után
fel van sorolva, hogy a függvény milyen kivételeket dobhat, vagy a függvényen belül kezelve van
pl FileNotFoundException
ez ilyen kivételes események ált. futási időben kijavíthatóak

Stackoverflow:

If you call a method which is declared to throw a checked exception (such as IOException),
the compiler will check that you're either catching it or declaring that you rethrow it.
Likewise, in order to throw such a checked exception in the first place, the compiler checks
that you've declared it as part of the method signature.

Basically, it's a little bit like type checking, except in terms of which exceptions
can be thrown by a method.

The compiler doesn't perform any checking for unchecked exceptions - so they can be
thrown by any method, without the method declaring them.

https://stackoverflow.com/questions/13104251/why-are-exceptions-named-checked-and-unchecked


NEM ELLENŐRZÖTT KIVÉTELEK
a fenti fordítási idejű ellenőrzést a compiler nem teszi meg
pl IllegalArgumentException, ArithmeticException, tömb kiindexelés
 - RuntimeException
 - Error

Stackoverflow:

Checked Exception: They are used to represent problems that can be recovered during the
execution of the program. They usually are not the programmer's fault. For example, a file
specified by user is not readable, or no network connection available, etc., In all these
cases, our program doesn't need to exit, instead it can take actions like alerting the user,
or go into a fallback mechanism(like offline working when network not available), etc.

Unchecked Exceptions: They again can be divided into two: Errors and RuntimeExceptions.
One reason for them to be unchecked is that they are numerous in number, and required to
handle all of them will clutter our program and reduce its clarity. The other reason is:

- Runtime Exceptions: They usually happen due to a fault by the programmer. For example,
  if an ArithmeticException of division by zero occurs or an ArrayIndexOutOfBoundsException occurs,
  it is because we are not careful enough in our coding. They happen usually because some errors
  in our program logic. So, they must be cleared before our program enters into production mode.
  They are unchecked in the sense that, our program must fail when it occurs, so that we programmers
  can resolve it at the time of development and testing itself.

- Errors: Errors are situations from which usually the program cannot recover. For example,
  if a StackOverflowError occurs, our program cannot do much, such as increase the size of program's
  function calling stack. Or if an OutOfMemoryError occurs, we cannot do much to increase the amount
  of RAM available to our program. In such cases, it is better to exit the program. That is why
  they are made unchecked.

https://stackoverflow.com/questions/11589302/why-is-throws-exception-necessary-when-calling-a-function
*/


