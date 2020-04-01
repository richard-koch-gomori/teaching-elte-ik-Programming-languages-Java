

class Main
{
    public static void main(String[] args)
    {
        WildAnimal animal = WildAnimal.GIRAFFE;
        System.out.println(animal.ordinal());
        System.out.println(animal.getFood());
        System.out.println(animal);

        System.out.println(WildAnimal.listAllAnimals());
    }
}
