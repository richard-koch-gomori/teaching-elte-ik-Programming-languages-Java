// egy Java forrsáfájlban pontosan 1 db. public class lehet,
// és az osztálynév.java néven kell elmenteni

class Circle
{
    // private: csak a Circle metódusai férnek hozzá
    private double x = 0;
    private double y = 0;
    private double radius = 1;

    // setter metódus: adattag beállítást végzünk vele
    public void setX(double new_x)
    {
        x = new_x;
    }

    public void setY(double new_y)
    {
        y = new_y;
    }

    public void setRadius(double new_radius)
    {
        // lehetőségünk van adat ellenőrzést végezni, mielőtt beállítjuk az adattagot
        if (new_radius <= 0)
        {
            System.out.println("radius must be pos");
            System.exit(1); // leállítja a program futását, 1-es exitkóddal
        }
        radius = new_radius;
    }

    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    public String toString() // sztringben visszaadja a Circle adatait
    {
        // "(x, y), r = ..."
        return "(" + x + "," + y + "), r = " + radius;
    }
}

// felhasználó kód (user code)
public class Main
{
    public static void main(String[] args)
    {
        Circle c1 = new Circle();
        c1.setX(5);
        c1.setY(2);
        c1.setRadius(10);
        //System.out.println("c1 = " + c1.toString());
        System.out.println("c1 = " + c1);
        System.out.println("area = " + c1.getArea());
    }
}

