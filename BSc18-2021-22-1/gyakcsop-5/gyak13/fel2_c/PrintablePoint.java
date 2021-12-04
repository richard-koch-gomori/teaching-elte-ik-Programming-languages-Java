public class PrintablePoint extends Point implements Printable
{
    public PrintablePoint(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void print()
    {
        System.out.println("(" + super.getX() + "," + super.getY() + ")");
    }
}


