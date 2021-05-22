# Programozási nyelvek (BSc, 18) Java pótzh elméleti feladatsor



Az alábbi kérdésekre szövegfájlban kell a válaszokat elkészíteni.
Egy-egy válasz 5-10 mondatos legyen. A szövegfájlt a gyakorlatvezetőnek
kérjük elküldeni **inf-es email címről**. Az email tárgya "*Java ZH
elmelet*" legyen.

A válaszadáshoz semmiféle segédanyagot nem szabad használni, és a
diáktársakkal, illetve a külvilággal való kommunikáció is tilos. Ha
bármilyen kérdés, észrevétel felmerül, azt a gyakorlatvezetőnek kell
jelezni a Teams alkalmazáson keresztül.

### 1. kérdés

Mi a különbség a *túlterhelés* és a *felüldefiniálás* között?

Mutass rájuk egy-egy példát!

### 2. kérdés

Miben térnek el az ellenőrzött és a nem ellenőrzött kivételek?

Milyen megszorításokat kell követni a forráskódban az egyiknél, illetve
a másiknál?

### 3. kérdés

Két változó - `a` és `b` - egyenlőségét szeretnénk vizsgálni. Mi a
különbség az egyenlőség operátor és az `equals(..)` metódus használata
között? `(a == b)` vs. `(a.equals(b))`

Melyiket mikor használ(hat)juk, és miért?

### 4. kérdés

Mi a különbség láthatóság szempontjából öröklődés során a `protected` és
a `package-private` adattagok (és metódusok) között?

### 5. kérdés

Az alábbi példában a `main(..)`-ből hívott `makeNull(..)` függvényben a
paramétert (a példányosított `Foo` objektumra mutató referenciát)
`null`-ra állítjuk. A kód mégsem száll el `NullPointerException`-nel,
hanem a `"Hello from Foo!"` szöveget írja a képernyőre. Miért?

~~~{.java}
class Foo {
    @Override
    public String toString() {
        return "Hello from Foo!";
    }
}

public class Main {
    public static void makeNull(Object o) {
        o = null;
    }

    public static void main(String[] args) {
        Foo f = new Foo();
        makeNull(f);
        System.out.println(f.toString());
    }
}
~~~
