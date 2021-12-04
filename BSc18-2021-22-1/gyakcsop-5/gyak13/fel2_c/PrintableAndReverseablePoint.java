public class PrintableAndReverseablePoint extends Point implements Printable, Reversable
{
    private int prev_x, prev_y;

    public PrintableAndReverseablePoint(int x, int y)
    {
        super(x, y);
        this.prev_x = x;
        this.prev_y = y;
    }

    public void setX(int x)
    {
        this.prev_x = super.getX();
        super.setX(x);
    }

    public void setY(int y)
    {
        this.prev_y = super.getY();
        super.setY(y);
    }

    @Override
    public void reverse()
    {
        super.setX(this.prev_x);
        super.setY(this.prev_y);
    }

    @Override
    public void print()
    {
        System.out.print("(" + super.getX() + "," + super.getY() + ")" + System.lineSeparator());
    }
}
