public class Guest{
    protected String name;
    protected int age;
    
    public Guest(String name, int age){            //Feladat nem írja, de unittesztekhez kell (alosztályokban is). 
        this.name=name;
        this.age=age;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAge(){
        return this.age;
    }
}
