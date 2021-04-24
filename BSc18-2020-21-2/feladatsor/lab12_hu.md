# Programozási nyelvek (BSc, 18) Java 12. feladatsor



### 1. feladat

Írjon a `DoubleVector` osztályához saját `equals()` és `hashCode()` metódusokat. Készítsen unit test-eket az `equals()` és `hashCode()` metódusok "szerződésében" foglalt elvárások alapján.

~~~{.java}
class DoubleVector
{
    double[] coords;

    public DoubleVector(double x1, double x2)
    {
        this.coords = new double[2];
        this.coords[0] = x1;
        this.coords[1] = x2;
    }

    public String toString()
    {
        return "(" + this.coords[0] + "," + this.coords[1] + ")";
    }
}
~~~

~~~{.java}
class Main
{
    public static void main(String[] args)
    {
        System.out.println(new DoubleVector(2, 3).equals(new DoubleVector(2, 3)));
        System.out.println(new DoubleVector(2, 3).equals(new DoubleVector(2, 2)));

        HashSet<DoubleVector> exampleSet = new HashSet<DoubleVector>();
        exampleSet.add(new DoubleVector(0, 0));
        exampleSet.add(new DoubleVector(3, -7));
        exampleSet.add(new DoubleVector(3, -7));
        System.out.println( "size of HashSet: " + exampleSet.size());
        System.out.println( "items of HashSet: " + exampleSet);
    }
}
~~~

### 2. feladat

Egy pontnak (`Point`) `x`, `y` (`int` típusú) koordinátája van. Ilyen pontok (teljesen) rendezhetőek lexikografikus rendezéssel. Ezen rendezést használva implementáljon `compareTo()` metódust. Példaként rendezze pontok listáját.

### 3. feladat

Írjon `ExtendedString` osztályt, amely `String` típusú adatot tárol, a sztring hossza alapján összehasonlítható (`compareTo()`), karakterenként iterálható (`iterator()`).

### 1. gyakorló feladat

Módosítsa a 5. feladatsor 1. gyakorló feladatában, a `Person` osztályhoz írt `equals()` metódust úgy, hogy megfeleljen az `equals()` metódussal szembeni elvárásoknak és írjon alkalmas `hashCode()` metódust.

