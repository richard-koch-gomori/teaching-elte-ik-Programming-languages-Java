//Készítette: Lukács Dávid István
public class Main {
    public static void main(String[] args){
        CheckedSet<Circle> test=new CheckedSet<Circle>();
        Circle test1=new Circle(5,4,20);
        try
        {
        test.add(test1);
        test.add(new Circle(3,5,22));
        test.add(new Circle(7,5,23));
        test.add(new Circle(1,3,25));
        test.add(test1);
        }
        catch(AlreadyContainedException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(test.size());
        System.out.println(test.toString());
    }
}