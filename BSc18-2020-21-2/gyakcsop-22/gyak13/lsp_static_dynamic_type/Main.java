// Jónás Bendegúz Gergő megoldása Koch-Gömöri Richárd kommentjeivel

/*
Az öröklődésnek 2 funkciója van:
- kódöröklés (eddig ezt vizsgáltuk)
- altípusképzés: Dog altípusa (subtype) Animal-nak
*/


public class Main
{
    public static void main(String[] args)
    {
        Animal a = new Dog(); // 2 db tipus - Statikus tipus: Animal
        //                                    Dinamikus tipus: Dog
        // Nem típusütközés, mert a Liskov Substitution Principle (Liskov-féle helyettesítési szabály)
        // azt mondja ki, hogy "a szülő helyettesíthető a gyerekével"

        // Felüldefiniált (és nem statikus) metódushívások esetében futási időben dől el
        // hogy az ősosztály vagy a leszármazott osztály metódusa hívódik-e meg (dynamic binding, dinamikus kötés)
        // Az a változó dinamikus típusa Dog, így a Dog osztály walk() metódusa hívódik meg
        a.walk();
    }
}

class Animal
{
    public void walk()
    {
        System.out.println("Animal walks...");
    }
}

class Dog extends Animal
{
    @Override
    public void walk()
    {
        System.out.println("A dog walks...");
    }
}

/*
Liskov Substitution Principle (Liskov-féle helyettesítési szabály):

Functions that use pointers or references to base classes must be able to use
objects of derived classes without knowing it. (Stackoverflow)

A szülő osztály példányának referenciája bármikor helyettesíthető a
leszármazott osztály példányának referenciájával.
*/


