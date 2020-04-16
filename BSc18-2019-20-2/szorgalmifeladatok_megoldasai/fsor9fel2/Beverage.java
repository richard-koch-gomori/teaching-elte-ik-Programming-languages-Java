public class Beverage{
    private String name;
    private int legalAge;
    
    public Beverage(String name, int legalAge){
        if(name==null || name.length()<1 || legalAge < 0){
            throw new IllegalArgumentException();
        } else {
            this.name=name;
            this.legalAge=legalAge;
        }
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getLegalAge(){
        return this.legalAge;
    }
}