# Programozási nyelvek (BSc, 18) Java pótzh programozási feladat

## Szabályok

Az alábbi feladatleírásban azon nyelvi elemek (osztályok, metódusok stb)
leírása szerepel, amelyeknek kötelező megjelennie a megoldásban. Ezeken
kívül további rejtett adattagok és metódusok, valamint nyilvános
setter/getter metódusok felvétele megengedett. A `toString()` metódus
implementálása debug céllal megengedett. Ha a feladatleírásban meg van
adva egy nyelvi elem (adattag vagy metódus) neve, kötelező azt
használni. A nyelvi szabályok mellett betartandóak a Java nyelv
konvenciói is.

Ha bármilyen kérdés, észrevétel felmerül, azt a gyakorlatvezetőnek kell
jelezni a Teams alkalmazáson keresztül.

Az elkészített megoldásokat **generált fájlok** (`.class, .jar`)
**nélkül** a gyakorlatvezetőnek kérjük elküldeni **inf-es email
címről**. Az email tárgya *"Java ZH gyakorlat"* legyen. Az emailhez
csatolni kell a megoldást zip archívumba csomagolva. A zip-fájlban a
csomagoknak megfelelő könyvtárak is legyenek eltárolva.

A beadott megoldásban a függvények közepén debug céllal elhelyezett
`System.out.println(..)` hívások **ne** szerepljenek!

Linux alatt az alábbi paranccsal hozhatunk létre zip-fájlt:

~~~
zip -r megoldas.zip *
~~~
Használható segédanyagok:

- [Letölthető zip fájl](base.zip), amely tartalmazza a junit tesztelő
  környezet jar fájljait, valamint a `resources` könyvtárban a
  mintaként adott szöveges inputfájlokat.
- [Java dokumentáció](https://bead.inf.elte.hu/files/java).
- Legfeljebb egy üres lap és toll.

## A feladat összefoglaló leírása

Egy ingatlanügynökség (`Agency`) különböző típusú házakkal (`House`)
kereskedik. Minden háznak van alapterülete, az egyes háztípusok ezen
felül különböző egyéni tulajdonságokkal is rendelkeznek, melyek alapján
megállapítható a ház ára (az egyszerűség kedvéért ezt \$-al fogjuk
jelezni).

Az ügynökség tud vásárolni és eladni is házakat.

A házakon az egyenlőség fogalma definiálásra kerül (`equals(..)`),
valamint értelmezünk rajtuk természetes összehasonlítást is
(`compareTo(..)`).

## Alapfeladat (21 pont)

### `House` (4 pont)

Készítsd el a `realestate.House` osztályt, mely az ingatlanok / házak
absztrakt őse lesz!

Minden ingatlannak van egy alapterülete (`floorArea`), melyet
létrehozáskor adhatunk meg (egész érték), és mely utólag már nem
módosítható. Ha az alapterület nem szigorúan pozitív, a konstruktor
dobjon `IllegalArgumentException` kivételt! Az alapterület legyen
lekérdezhető bárki számára egy `getter` metóduson keresztül!

Minden ház rendelkezik egy egyedi, egész típusú helyrajzi számmal
(`parcelNumber`), mely csak a leszármazottak számára látható, és az
objektum létrehozása után már nem módosítható. A helyrajzi számot
automatikusan, egyedi értékekkel hozd létre a konstruktorban! (Az
elsőként létrehozott házé 0, a másodiknak 1, a következőé 2, stb.)

Készítsd el a `getPrice()` nevű, implementáció nélküli metódust, melyet
csak a `realestate` package-ben lehessen elérni! A metódus valós
értékekkel fog visszatérni, ám minden háztípusnál más módon kell
megállapítani annak árát.

### `DetachedHouse` (2 pont)

A kertesházakat a `realestate.DetachedHouse` osztály fogja
reprezentálni, mely a fenti `realestate.House` osztályból származik.

A kertesházakat az alapterületükön kívül a hozzájuk tartozó kert
területe jellemzi (`gardenArea`, szintén egész).

A kertesházak árának megállapításához össze kell adni az alapterületet,
valamint a kert méretének kétszeresét, és ezt kell megszorozni a
kertesházak állandó szorzójával, mely szorzó értéke `60`. Definiáld
felül a `getPrice()` metódust ez alapján! (Egy 100m^2^ alapterületű,
30m^2^ kerttel rendelkező kertesház ára így 9600\$ kell, hogy legyen).

A kertesházhoz nem kötelező, de célszerű lehet a `toString()` metódus
implementálása.

### `Flat` (2 pont)

A lakásokat a `realestate.Flat` osztály reprezentálja, mely a
kertesházakhoz hasonlóan a fenti `realestate.House` osztályból
származik.

A lakásoknál az erkélyek száma (`balconyCount`) bír jelentőséggel az
alapterületükön kívül.

A lakás árának megállapításához össze kell adni az alapterületet,
valamint az erkélyek számának húszszorosát, és ezt kell megszorozni a
lakásokhoz tartozó állandó szorzóval, melynek értéke `80`. (Egy 50m^2^
alapterületű, két erkéllyel rendelkező lakás ára így 7200\$ kell, hogy
legyen).

A lakásokhoz sem kötelező, de itt is célszerű lehet a `toString()`
metódus implementálása.

### `Agency` (8 pont)

Hozd létre az ingatlanügynökség reprezentálására a `realestate.Agency`
osztályt!

Az ingatlanügynökségeket a nevük ( `name` - szöveges), a pénzük (`money`
- valós), a megvásárolható ingatlanok (`House`) listája
(`availableHouses` - `ArrayList<>`) és az eddig eladott házak száma
(`housesSold`) reprezentálja.

A konstruktorban a nevet és a kezdőtőkét lehessen megadni, a házak
listája kezdetben üres, az eladott ingatlanok száma pedig 0 legyen!

Ha a névnek megadott referencia `null`, vagy a hossza `0`, úgy a
konstruktor dobjon `IllegalArgumentException`t!

Készíts `getter` műveleteket az ügynökség pénzének, az eladott házak
számának és az elérhető ingatlanok listájának lekérdezéséhez! Figyelj
rá, hogy az utóbbi ne szivárogtassa ki a belső állapotot, hanem
másolatot készítsen az eredeti listáról!

Lehessen az ügynökségtől lekérdezni, hogy nála mennyibe kerülne egy
adott ingatlan! Ehhez készítsd el a `getHouseCost(..)` műveletet,
melynek paramétere egy `House` típusú objektum. Az ügynökség 10%-os
haszonnal dolgozik, emiatt minden esetben a ház eredeti értékének
110%-át fogja visszaadni ez a művelet!

Legyen lehetősége az ügynökségnek ingatlant vásárolni, hogy később
továbbadhasson rajta! Ehhez készítsd el a `buyHouse(..)` nevű, publikus
metódust, mely paraméterül egy `House` típusú objektumot kapjon. Az
ügynökség mindig féláron veszi meg az ingatlanokat (azaz egy 1000\$-t
érő lakásért 500\$-t fizet). Amennyiben van elég pénze a félárú
vásárlásra, úgy az ügynökségtől megvásárolható házak listájához add
hozzá a kapott házat, az ügynökség pénzét pedig csökkentsd a megfelelő
módon. Ha nincs elég pénze, a függvénynek nincs feladata, nem kell hibát
jelezni. A metódus térjen vissza egy logikai értékkel a vásárlás
sikerességét jelezvén!

Készítsd el az ügynökség szöveges reprezentálásához a `toString()`
metódust úgy, hogy abban szerepeljen az ügynökség neve, az eddig
eladott, és a jelenleg megvehető ingatlanok száma is!

A letölthető fájlok között, a `resources` mappában találsz egy
`codesample.txt` nevű fájlt. Ebben egy
`buyPossibleHouses(String fileName)` szignatúrájú metódus
implementációja van. Ebben a szerző összesen **5 hibát** ejtett, melyek
korrigálása feladatod. A metódust - miután kijavítottad - illeszd be az
`Agency` osztályba. A metódus legyen bárki számára hívható, visszatérési
értéke nincs. A metódusban az ügynökség a kapott nevű fájlban szereplő
házak mindegyikét megpróbálja megvásárolni (a fentieknek megfelelően). A
fájlban egy sor egy ház leírását jelenti - ez pontosvesszőkkel tagolva
tartalmaz 3 adatot: az első a ház típusának kezdőbetűje (lakás esetén
`"F"`, kertesháznál pedig `"D"`. Ezután a ház alapterülete következik,
majd lakás esetén az erkélyek száma, kertesháznál pedig a kert területe.
Amennyiben a függvény a sor elején nem `"F"`-et vagy `"D"`-t olvas, úgy
hagyja figyelmen kívül az adott sort, és ne próbáljon vásárolni. Ha nem
létezik a fájl, vagy nem nyitható meg, a függvény lenyeli a kivételt,
nem dob hibát.

### `Tests` (5 pont)

Készíts a fentiek teszteléséhez egy `Tests` osztályt a `tests`
csomagban, melyben a unit-tesztelést végzed!

A tesztesetek ellenőrizzék az eddigiek helyes működését, az alábbi
esteket lefedve:

-   A `House` osztály konstruktora `IllegalArgumentException`t vált ki,
    ha az alapterület nem szigorúan pozitív.
-   Az `Agency` objektum példányosításakor hiba váltódik ki, ha `null`
    értéket vagy üres stringet adunk meg névnek.
-   Az ügynökség megfelelően adja vissza a házak árát, azaz rászámolja a
    saját profitját is! (A 7200\$-os lakás pl. 7920\$-ért vehető meg
    tőlük.)
-   Az ügynökség nem vásárol házat, ha nincs rá elég pénze.
-   Ha az ügynökség házat vásárol, úgy a pénzük a megfelelő módon
    csökken.
-   Ha az ügynökség házat vásárol, úgy a nála megvásárolható házak
    listájában megjelenik a megvett ingatlan.
-   Egy `Agency` típusú objektumon a `buyPossibleHouses(..)` metódus
    hívása a megadott mintafájllal sikeresen feltölti a helyes sorokkal
    az ügynökség elérhető ingatlanjait (a négy sikeres vásárláshoz
    legalább 17400\$-ral kell rendelkeznie).

Emlékeztető a JUnit használatához:

- Az `org.junit.Assert` osztályt (és/vagy annak statikus metódusait, pl.
  `assertEquals`) kell importálni, valamint az `org.junit.Test` annotációt.
- A JUnit futtatása, ha a tesztesetek osztálya a névtelen csomagba tartozó
  `SimpleTest` osztály, a következő parancsokkal történik.

Windows:

```
javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar SimpleTest.java
java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore SimpleTest
```

Linux:

```
javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar SimpleTest.java
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore SimpleTest
```

## Egyenlőség (4 pont)

Készítsd el az `equals(..)` metódust a `DetachedHouse` és a `Flat`
oszályokban!

Két kertesház abban az esetben egyenlő, ha az alapterületük és a kertjük
mérete is egyforma. Két lakást akkor tekintünk egyenlőnek, ha az
alapterületük és az erkélyeik száma is megegyzik. (A helyrajzi számukat
nem kell figyelembe venni egyik esetben sem!)

Készítsd el a `hashCode()` metódus implementációit is, melyekben
ugyanezeket az adattagokat használod!

Készíts tesztet, melyben megvizsgálod, hogy egyenlő objektumokra az
`equals(..)` igazat, a `hashCode()` pedig azonos értéket ad-e!
Ellenőrizd az előbbi fordítottját is, miszerint különböző objektumokra
az `equals(..)` hamis értéket ad!

## Összehasonlítás, eladás (5 pont)

Készítsd el a `sellHouse(..)` metódust az `Agency` osztályban!
Paraméterül egy házat kap. Amennyiben nincs az ügynökség által eladható
házak listájában a kapott ház, úgy a metódus dobjon
`HouseNotForSaleException` kivételt, mely egy általad létrehozott,
ellenőrzött kivétel!

Amennyiben a ház eladható, úgy távolítsd el a listából, növeld az
eladott házak számát, és az ügynökség pénzét is megfelelő módon (a
`getHouseCost(..)` alapján)!

Készíts teszteket, melyben ellenőrzöd hibás esetben a kivételt
kiváltódását, helyes működés során pedig az ügynökség pénzének, az
elérhető házak listájának és az eladott házak számának változását!

A `House` osztály valósítsa meg a `Comparable<>` `interface`t. Két ház
közül azt tekintjük kisebbnek, melynek kisebb az alapterülete. Egyenlő
esetben a kisebb helyrajzi számút tekintjük kisebbnek.

Ellenőrizd unit teszttel több példán is, hogy helyesen működik-e az
összehasonlítás!
