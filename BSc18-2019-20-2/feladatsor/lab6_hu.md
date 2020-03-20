# Programozási nyelvek (BSc, 18) Java 6. gyakorlat



### 1. feladat

Módosítsa a 3. gyakorlat 5. feladatát úgy, hogy egy `Point` objektumot paraméterek
nélkül is lehessen konstruálni! Ekkor az `x` és `y` adattagja 0-ra inicializálódjon.
Írjon a `Point` osztály `x` és `y` adattagjaihoz setter metódusokat. Oldja meg a
`Circle` konstruktorában azt, hogy az osztály a paraméterként kapott `Point`-ról
másolatot tároljon (ne csak referenciát).

Egy körnek mostantól legyen címkéje (neve) is! Bővítse a `Circle` osztályt egy
címke (`String`) tárolására alkalmas adattaggal. Konstruáláskor egy `String`
paraméterrel meg lehessen adni a kör címkéjét; a címke kerüljön be a `toString()`-be
is. Az osztálynak legyen egy `defaultLabel`, "unnamed" értékű statikus `final` adattagja.
Ha a konstruktor címkének `null` referenciát kap paraméterként, akkor a létrejövő
kör címkéje `defaultLabel` legyen.

A `Circle` osztálynak legyen olyan konstruktora, amely paraméterként nem `Point`
referenciát vár, hanem `x` és `y` `double` típusú koordinátákat, majd hívja meg
az előbb megírt `Circle` konstruktort.

Írjon a `Circle` osztályhoz statikus `readFromFile()` metódust, amely betölti
a paraméterben kapott fájlból egy kör adatait (`x` és `y` koordináta, sugár és címke
újsorral elválasztva), megkonstruál ezen adatokkal egy `Circle` objektumot,
majd visszatér az objektum referenciájával. Amennyiben a fájl feldolgozása
hibába ütközik (nem lehet megnyitni a fájlt; érvénytelen adatok vannak a fájlban)
akkor is jöjjön létre objektum csupa 0-szerű adatokkal.

Írjon a `Circle` osztályhoz `saveToFile()` metódust, amely az aktuális `Circle` objektum
adatait a paraméterként megadott fájlba menti. Amennyiben a fájlba írás kivételes
eseménybe ütközik, a függvény engedje tovább a kivételes eseményt a hívóhoz.
Gondoskodjon arról, hogy ha a kiírás menet közben ütközik kivételes eseménybe,
akkor a már kiírt adatok ne vesszenek el (azaz a `PrintWriter`-t mindenképpen
be kell zárni).

### 2. feladat

Módosítsa az 5. gyakorlat 3. feladatának a forráskódját a következőképpen:

Rendezze osztályszintű metódusba a korábban megírt logikát, a metódus viszont
a parancssori argumentumok tömbjén kívül kapjon egy double típusú értéket is,
amire vizsgálja meg, hogy a két argumentumon elvégzett művelet után kapott
érték lefele kerekítve egyenlő-e vele (`boolean`-nal térjen vissza). A metódus
hiba esetén ne kezelje le a kivételeket, ez a `main()`-ből való meghíváskor történjen.

Írjon dokumentációs megjegyzést a fentebb leírt metódushoz, amiben leírja röviden
a funkcionalitását. Tartalmazza legalább az alábbi címkéket:

- `@param`
- `@returns`
- `@throws`

Készítsen az osztályhoz is dokumentációs megjegyzést. Tartalmazza az `@author`,
`@version`, `@since` tageket.

A `javadoc` program segítségével generáljon HTML dokumentációt a Java programhoz.

### 3. feladat

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

### 4. feladat

Módosítsa a 4. gyakorlat 2. feladatát úgy, hogy a `centerOfMass()` függvény
a `Point` referenciákat ne tömbben, hanem egy `LinkedList`-ben kapja meg.


### 1. gyakorló feladat

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
input fájl tartalmát, a létrehozott objektumokat pedig tároljuk el egy
`ArrayList`-be.

### 2. gyakorló feladat



### 3. gyakorló feladat




