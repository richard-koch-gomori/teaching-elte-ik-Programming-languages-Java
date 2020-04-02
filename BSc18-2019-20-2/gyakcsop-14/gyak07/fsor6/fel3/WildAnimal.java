

public enum WildAnimal
{
    // WildAnimal() konstruktor hívódik meg
    MONKEY("bananas", 5), // 0
    ELEPHANT("rasperries", 30), // 1
    GIRAFFE("apples", 10), // 2
    RACCOON("walnuts", 20); // 3

    // egy enum-nak adattagjai és metódusai is lehetnek

    private final String food;
    private final int amount;

    WildAnimal(String food, int amount)
    {
        this.food = food;
        this.amount = amount;
    }

    public String getFood()
    {
        return food;
    }

    public String toString()
    {
        return "A(n) " + this.name() + " eats " + this.amount + " " + this.food + " a day.";
    }

    public static String listAllAnimals()
    {
        StringBuilder sb = new StringBuilder();
        for (WildAnimal animal : WildAnimal.values()) // values() a felsorolt értékek gyűjteményét adja vissza
        {
            sb.append(animal.ordinal()); // ordinal() a felsorolt érték enum-beli sorszáma
            sb.append(": ");
            sb.append(animal.name()); // name() a felsorolt érték enum-beli neve
            sb.append(" desires eating ");
            sb.append(animal.amount * 7);
            sb.append(" ");
            sb.append(animal.food);
            sb.append(" a week.");
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}


/*
https://stackoverflow.com/questions/28436543/how-to-make-objects-of-an-enum-in-java

From stackoverflow:
The constructor is called when the enum class (Deck) is loaded by the classloader
and initialized. [[So the deck will be shuffled before any line of code can call any
method of the Deck class.]]"

https://stackoverflow.com/questions/14690771/when-is-an-enum-constructor-called
*/


