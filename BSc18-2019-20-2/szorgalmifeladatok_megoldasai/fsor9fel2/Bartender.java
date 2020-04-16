public class Bartender{
    public boolean order(Beverage beverage, Guest guest){
        if(guest instanceof Minor && beverage.getLegalAge() == 18 ){
            return false;
        } else {
            return true;
        }
    }
}