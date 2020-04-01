

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
        return "An " + this.name() + " eats " + this.amount + " " + this.food + " a day.";
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
