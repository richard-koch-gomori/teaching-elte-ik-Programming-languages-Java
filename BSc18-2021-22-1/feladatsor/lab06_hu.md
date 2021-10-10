# Programozási nyelvek (BSc, 18) Java 6. feladatsor



### 1. feladat

Készítsen egy `IntegerMatrix` nevű osztályt a következő metódusokkal.

Egy konstruktor, mely 3 paramétert vár:

`int rowNum` (A mátrix sorainak száma)  
`int colNum` (A mátrix oszlopainak száma)  
`int[] linearData` (Egy, a mátrix elemeit sorfolytonosan tároló tömb)

Egy `toString()` metódus, mely egyetlen karakterláncba felsorolja a
mátrix elemeit. A karakterláncban az egy sorban szereplő elemeket a `,`
karakterrel válassza el; a sorokat a `;` karakterrel válassza el!

Például `linearData = {1,2,3,4,5,6}` esetén az
`IntegerMatrix(2,3,linearData)` konstruktorhívás hatására a következő mátrix
készül:

```
[1 2 3]
[4 5 6]
```

Ez esetben objektum `toString()` metódusa a következő sztringgel tér vissza:
`"1,2,3;4,5,6"`.

### 2. feladat

#### a

Módosítsa az **1. feladatsor 7.** feladatának megoldását úgy, hogy az operandusok
`double` típusúak legyenek, valamint az elvégezendő műveletet is parancssori
argumentumként fogadja a program. A program csak a kért típusú alapműveletet
végezze el.

Amennyiben nem megfelelő számú argumentummal hívták meg a programot, akkor
a `main()` függvény dobjon `IllegalArgumentException` kivételt. Nullával való
osztás esetén dobjon `ArithmeticException` kivételt; nem támogatott alapművelet
esetén pedig `IllegalArgumentException` kivételt.

#### b

Módosítsa az előző megoldást úgy, hogy a `main()` függvény kapja el a dobott
kivételeket, és ezek előfordulása esetén általános hibaüzeneteket írjon ki
a képernyőre (például nem megfelelő számú argumentum esetén "Invalid program
arguments provided."). A `parseDouble()` konverziós metódus érvénytelen sztring
esetén `NumberFormatException` kivételt dob; kapja el ezt a kivételt is.

#### c

Módosítsa az előző megoldást úgy, hogy a kivételek konstruálásakor informatív
üzenetet ad át a kivétel konstruktorának; a kivétel kezelésekor írja ki a
kivétel objektumban tárolt üzenetet.

### 3. feladat

Ebben a feladatban a **4. feladatsor 4/b** feladatát érdemes továbbfejleszteni.

#### a

Írjon a `Circle` osztályhoz statikus `readFromFile()` metódust, amely betölti
a paraméterként kapott fájlnevű fájlból egy kör adatait (`x` és `y` koordináta és sugár újsorral elválasztva), megkonstruál ezen adatokkal egy `Circle` objektumot,
majd visszatér az objektum referenciájával. A függvény a fellépő kivételeket
engedje tovább a hívóhoz.

Írjon a `Circle` osztályhoz `saveToFile()` metódust, amely az aktuális `Circle` objektum
adatait a paraméterként megadott fájlnevű fájlba menti. Amennyiben a fájlba írás kivételes
eseménybe ütközik, a függvény engedje tovább a kivételes eseményt a hívóhoz.
Gondoskodjon arról, hogy ha a kiírás menet közben ütközik kivételes eseménybe,
akkor a már kiírt adatok ne vesszenek el (azaz a `Writer` objektumot mindenképpen
be kell zárni).

Próbálja ki mi a különbség ha a hívott függvények kivételeit elkapja illetve nem kapja el a főprogramban.

#### b

Készítse el az **a** megoldás egy olyan változatát, amelyben a `readFromFile()`
metódus megpróbálja kezelni a fellépő kivételes eseményeket: ha valamilyen kivételes
esemény miatt nem sikerül a beolvasás, akkor jöjjön létre kör objektum valamilyen értelmes kezdőértékekkel.

### 4. feladat

Készítse el a `WildAnimal.java` fájlba a `WildAnimal` felsorolási típust (`enum`-ot),
amelyben legyen négy felsorolási tag: majom, elefánt, zsiráf és mosómedve.
Az állatok konstruktorában első paraméternek megkapják azt, hogy melyik gyümölcsöt
szeretik enni, második paraméterként pedig azt, hogy mennyi lenne ideális esetben
egy napi adagjuk az adott gyümölcsből. 

Készítse el a `listAllAnimals()` metódust, amely egy ilyen formátumú szöveggel
tér vissza:

"_A vadállat sorszáma_: _a vadállat neve_ szeretne enni _a vadállat gyümölcse_ egy héten."

Például, ha az elefánt megadott napi mennyisége 30 málna volt:  
"2: Elefánt szeretne enni 210 málnát egy héten."

Az `enum` elemeinek bejárásához használja a `values()`, illetve a sorszám lekérdezéséhez
az `ordinal()` metódust.

Készítsen saját `toString()` metódust, amely az adott `enum` elem által meghívott
állatról írja ki az információkat.

Próbálja ki az elkészített felsorolási típust és a hozzátartozó metódusokat egy
`Main` osztályban.

### 1. gyakorló feladat

Készítsünk egy, a nemek ábrázolásához használt `Gender` nevű felsorolási típust!
Ebben szerepeljen két érték, amelyek rendre `Gender.MALE` (férfi) és
`Gender.FEMALE` (nő). Készítsünk `Person` névvel egy olyan osztályt,
amelyben nyilvántartjuk a személyi adatokat! A rögzíteni kívánt adatok:
a személy vezeték és keresztneve (mindkettő `String`), foglalkozása (`String`),
neme (`Gender`) és születési éve (`int`).

Legyen a `Person` osztálynak egy olyan konstruktora, mely ezeket az adatokat
paraméterként kapja.

Egészítsük ki a `Person` osztályt egy `toString()` metódussal, amely `String`
típusú értékké alakítja az adott objektum belső állapotát! Készítsünk egy
`equals()` nevű metódust a `Person` osztályhoz, amely eldönti a paraméterként
megadott másik `Person` objektumról, hogy megegyezik-e az aktuális példánnyal.
Vigyázzunk arra, hogy mivel referenciát adunk át paraméterként, az lehet
(többnyire véletlenül) `null` érték is! Ilyenkor értelemszerűen az eredménye
hamis lesz.

Tegyük az eddigi osztályokat a `person` csomagba és készítsünk hozzá egy
főprogramot, amelyben létrehozunk két `Person` objektumot, megvizsgáljuk,
hogy ugyanarról a két személyről van-e szó és az eredményt kiírjuk a szabványos
kimenetre! A főprogram kerüljön a `main` csomagba!

### 2. gyakorló feladat

Készítsünk egy `basics.Matrix` osztályt (valós számokat tartalmazó
kétdimenziós tömb mint mátrix segítségével), amelynek a következő
műveletei vannak: M × N méretű nullmátrix konstruálása, M × N méretű
mátrix konstruálása M × N méretű tömb segítségével, N × N dimenziós
egységmátrix létrehozása (az eredmény mátrix legyen visszatérési érték),
mátrix transzponáltjának ill. két mátrix összegének, különbségének kiszámítása,
a mátrix sztringként történő ábrázolása (`java.lang.StringBuilder`-t használjunk
a szöveg előállításához).

Készítsünk főprogramot (Main.java) is, amely teszteli ezen műveleteket!

### 3. gyakorló feladat

Készítsen egy `TelevisionShop` felsorolási típust. A felsorolási tagok legyenek
`SAMSUNG`, `LG`, `SKYWORTH`, `SONY`, `SHARP`. A konstruktorukban az első tag legyen, hogy
hány db készülék van az adott márkából raktáron, a második és a harmadik az elérhető
átmérők minimuma és maximuma legyen. Készítsen hozzá olyan metódusokat, amelyekkel
ki tudja íratni az összes lehetséges kapható méret minimumát és maximumát típustól
függetlenül (statikus) és olyat, amely adott márkára kiírja, hogy mekkora méretű
tévéket lehet kapni. Készítsen statikus metódust, amellyel kiírja a rendelkezésre
álló készletről minden tudhatót!

Használja a `final` kulcsszót, ahol lehet!

### 4. gyakorló feladat

Bővítse a 5. feladatsor 2. gyakorló feladat megoldását a következő metódusokkal:

A vektorhoz lehessen hozzáadni egy újabb elemet. Itt figyeljünk rá, hogy
a mérete dinamikusan növekedjen (ha megtelt a tömb, akkor csináljunk egy
segédtömböt 2x akkora mérettel, másoljuk át az elemeket és állítsuk át a
számokat tároló tömb referenciáját a segédtömbére).

Legyen egy statikus `sum()` függvénye, amely vár két `IntVector` objektumot
és összeadja őket, majd visszatér az eredmény referenciájával.

### 5. gyakorló feladat

Javítsuk ki a HIBÁS programo(ka)t!

Készítsünk a `util` csomagon belül egy `IntVector` osztályt, amely
egészek sorozatát ábrázolja!
Legyen egy tömb adattagja, amely a sorozatot tárolja.
Adjunk az osztályhoz egy konstruktort, amely egy egészekből álló
tömböt vár paraméterül (ennek tartalmát másolja le).
Vegyünk fel egy `add()` metódust, mely a sorozat minden eleméhez
hozzáad egy paraméterül kapott egész számot!
Készítsünk egy `toString()` metódust is, mely felsorolja a számokat
szóközzel elválasztva (használjon `StringBuilder`-t). Például: `[1 2 3]`

util/IntVector.java:

~~~{.java}
package util;

public class IntVector {
    int[] numbers;

    IntVector(int[] numbers) {
        numbers = numbers;
    }

    public void add(int n) {
        for (int i = 0; i < numbers.length-1; i++)
            numbers[i] += n;
    }

    public String toString() {
        return Arrays.toString(numbers);
    }
}
~~~

IntVectorDemo.java:

~~~{.java}
class IntVectorDemo {
    public static void main(String[] args) {
        int[] ns = new int{1,2,3};
        IntVector v = new IntVector(ns);
        IntVector v2 = new IntVector(ns);

        System.out.println(new int{1,2,3});
        System.out.println(v);
        System.out.println(v2);

        System.out.println("v.add(1);");
        v.add(1);
        System.out.println(v);
        System.out.println(v2);

        System.out.println("ns[0] = 10;");
        ns[0] = 10;             
        System.out.println(v);
        System.out.println(v2);
    }
}
~~~

### 6. gyakorló feladat

Készítsünk egy egyszerű `Color` felsorolt típust, mely a következő értékeket
tárolhatja: `RED`, `GREEN`, `BLUE`.

Írjunk egy `Auto` osztályt, mely a következő információkat tárolja:

- rendszám (`String`)
- szín (`Color`)
- maximális sebesség (`int`)

Írjunk az osztályhoz egy konstruktort, mely ezt a három értéket várja
paraméterként. Az osztályban legyen számláló, mely tárolja, hogy hány
objektumot hoztunk eddig létre.

Írjunk egy paraméter nélküli konstruktort is, mely `AAA-000`, `BLUE`
és `120` értékekkel hoz létre objektumot.

Írjunk egy osztályszintű összehasonlító metódust, mely két autó
objektumot vár, és igazzal tért vissza, ha az első gyorsabb mint a
második.

Helyezzük a `Color` osztályt az `auto.utils` csomagba, az `Auto`-t
pedig az `auto` csomagba!

Hozzunk létre egy `input.txt` fájlt, melyben autók adatai vannak
soronként megadva, vesszővel elválasztva. Pl: ABC-123,RED,100

Írjunk egy `Main` osztályt (a csomogokon kívül), amely a tesztprogramunkat
fogja tartalmazni! A `Main` osztály `main()` metódusában olvassuk be az
input fájl tartalmát, a létrehozott objektumok referenciáit pedig tároljuk
el egy tömbben.

### 7. gyakorló feladat

Készítse el az előadáson már előforduló `Time` osztályt teszőlegesen választható
időreprezentációval. Kezelje le az előfoduló kivételeket és legyen egy metódusa,
ami `String`-ként visszaadja az időt.

Készítsen egy `Pizza` osztály, amelynek legyen az összes mezője `private` és `final`;
egy mezője az átmérő (`double`), egy a feltétek listája (`String[]`), egy az
elkészítési idő (`Time`) és egy a szállítási idő (`Time`). Írjon hozzá konstruktort,
amely a feltétek szerint kiszámolja, hogy mennyi az elkészítési idő, tehát az ne
legyen paraméterül átadva a konstruktornak. Az elkészítési idő a következő képlet
szerint történjen: az összes feltétre a következők összege: a feltét nevének hossza
szorozva a pizza átmérőjével (centiméterenként és feltétbetűnként egy másodperc).

Pl.: 32 cm-es pizza "cheese" feltéttel: `32*6 = 192`, amit kerekítsünk 4 percre.
A konstruktor dobjon kivételt, ha valamely paraméter nem értelmezhető. Dobjon
`TypeNotPresentException`-t, ha a feltét nincs benne a következő listában:
`beef`, `cheese`, `corn`, `fish`, `ham`, `mushroom`, `salami`, `tomato`. Jelenítse meg a `throws`
kulcsszóval, hogy a `Pizza` osztály példányosításakor le kell kezelni a
`TypeNotPresentException`-t.

Írjon `Main` programot, amelynek egy statikus metódusa beolvas a paraméterként
átadott fájnévű fájlból pizzarendeléseket, és létrehozza egy listában az összes
lehetséges pizzát, majd kiszámítja, hogy mennyi ideig kell aznap sütni. Kezelje le
a kivételeket, amelyek felléphetnek a pizzák létrehozása során.

Végül mutassa be ennek a `Main` osztálynak statikus metódusának használatát a
`Main` osztályon belül.


