//készítette:Lukács Dávid István
public class ColouredCircle extends Circle 
{
    private Colour circleColour;

    ColouredCircle(ColouredPoint c,int r,String l)
    {
        super(c,r,l);
        circleColour= c.getColour();
    }

    public Colour getcColour(){return circleColour;}
}
