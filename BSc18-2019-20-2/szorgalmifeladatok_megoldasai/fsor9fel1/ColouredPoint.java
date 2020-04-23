//készítette:Lukács Dávid István
public class ColouredPoint extends Point
{
    private Colour pointColour;
    public void setColour(Colour c)
    {
        this.pointColour=c;
    }
    public Colour getColour()
    {
        return this.pointColour;
    }

    public ColouredPoint(Colour c, double x, double y)
    {
        super(x,y);
        pointColour=c;
    }

}