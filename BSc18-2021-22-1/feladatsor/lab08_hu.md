# Programozási nyelvek (BSc, 18) Java 8. feladatsor



### 1. feladat

Készítsen `divisors()` néven függvényt, amely a paraméterként kapott pozitív egész szám
osztóit adja vissza egy [`LinkedList`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/LinkedList.html) adatszerkezetben.

### 2. feladat

Készítsen `minToFront()` néven függvényt, amely egész számok [`ArrayList`jét](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/ArrayList.html) kapja
paraméterként. A függvény tolja a lista elejére a legkisebb előforduló számot a
többi szám sorrendjét meghagyva. Például a `[4, 65, 45, 44, 76, 2, 98, 72]` bemenetre
a helyes eredmény: `[2, 4, 65, 45, 44, 76, 98, 72]`. A minimumkereséshez használja a
[`Collections.min()`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collections.html#min(java.util.Collection)) függvényt. Ha a paraméterként kapott lista üres, a függvény
dobjon [`IllegalArgumentException`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/IllegalArgumentException.html) kivételt.

### 3. feladat

Készítsen egy `Bag<T>` generikus osztályt, mely egy zsákot valósít meg. A zsák olyan halmaz,
mely többször tartalmazhatja ugyanazt az elemet.

Legyen egy [`HashMap<T, Integer>`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html) adattagja, melyet a paraméter nélküli
konstruktor megfelelően feltölt. Legyen egy `add(T element)` metódusa. Ellenőrizze, hogy van-e már
ilyen kulcs a zsákban, ha nincs, tegye bele `1` értékkel. Ha van, kérdezze le az aktuális értéket,
és tegye bele az `1`-gyel megnövelt értéket (azt tároljuk a map-ben, hogy melyik objektum hányszor
van a zsákban).

Legyen egy egész visszatérési értékű `countOf(T element`) metódusa, mely megadja, hogy hányszor van
az elem a zsákban. Ha nincs az elemhez mint kulcshoz rendelve semmilyen érték a map-ben, adjon vissza `0`-t.

Legyen a zsáknak egy `remove()` metódusa is egy elem kivételére. Csökkentse `1`-gyel a megadott elem
darabszámát a zsákban. Ha `0`-ra csökken a darabszám, vegye ki a megfelelő kulcs-érték párt a map-ből,
hogy ne tároljunk feleslegesen adatokat. Ha az elem nem volt a zsákban, dobjunk `NotInBagException` kivételt,
amely legyen egy saját kivétel osztály. A `NotInBagException` kivétel származzon [`Exception`ből](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Exception.html), és a
sztringet fogadó konstruktora hívja meg az ősösztály konstruktorát.

Készítsen főprogramot, amely a `Bag<T>` generikus típus felhasználásával beolvas egy olyan szöveges fájlt,
amely soronként egy szót tartalmaz, majd a szavak előfordulási gyakoriságáról statisztikát készít.

input.txt:

```
hello
world
interface
abstract
abstract
world
world
world
hello
world
X-Files
protected
abstract
abstract
extends
protected
socket
world
hello
socket
extends
```

### 1. gyakorló feladat

Készítsen egész számok listáját reprezentáló adatszerkezetet `IntList` néven. Egy (a) részfeladat
keretében készítse el az adatszerkezet hagyományos, tömbökön alapuló megoldását.

#### a

Az `IntList` osztálynak adattagokban tárolja az `IntList` aktuális és maximális méretét.
A maximális méretet a konstruktor állítja be. Az osztálynak legyen egy `add()` metódusa,
amellyel egy `int` típusú adatot tehetünk be az `IntList`-be. Írjon `concat()` függvényt,
amely egy másik `IntList` referenciát vár paraméterként, és ha az aktuális `IntList` elég nagy,
akkor a végéhez fűzi a paraméterként kapott `IntList`-ben található egészeket. Ha az `IntList`
nem elég nagy elemek hozzáadásakor, akkor a metódusok dobjanak `IllegalStateException`-t.
Írjon `toString()` metódust, amely vesszővel elválasztva felsorolja az `IntList` elemeit.
Amennyiben az `IntList` üres, akkor a `toString()` az "empty" sztringet adja vissza.
Írjon `removeItemsGreaterThan()` metódust, amely paraméterként egy egész számot (`limit`)
fogad, és az `IntList` csak azon elemeit hagyja meg, amelyek nem nagyobbak `limit`-nél.

#### b

A (b) részfeladat ugyanezt az adatszerkezetet valósítsa meg `ArrayList` vagy `LinkedList`
használatával (milyen előnyei vannak a (b) megoldásnak az (a) megoldással szemben?)
Az `IntList`-nek legyen olyan konstruktora, amely egész számok tömbjével inicializálja
az újonnan létrehozott `IntList`-et.
Írjon `getData()` metódust, amely visszatér a tárolt számok listájával. Vigyázzon arra,
hogy a metódus ne szivárogtassa ki az osztály belső állapotát.

#### c

A (c) részfeladatban származtasson `NamedIntList` néven osztályt a (b) feladatban megírt
`IntList` osztályból. Egy egészek listájának mostantól legyen neve is, a `NamedIntList` osztály
tárolja egy sztring adattagban. Írjon konstruktorokat, amelyek egy nevet illetve egy nevet és
egy egészeket tartalmazó tömböt fogadnak, majd ezen adatokkal inicializálja a létrejött
`NamedIntList` objektumot. Definiálja felül az ősosztálytól örökölt `toString()` metódust
úgy, hogy a sztringben tüntesse fel a `NamedIntList` nevét is.

### 2. gyakorló feladat

Írjon függvényt, amely visszatér a paraméterként kapott sztring betű-statisztikájával:
A sztringben minden előforduló betűről tartalmazza, hányszor fordul elő az adott karakter.
Használja a Java `HashMap` adatszerkezetét, ahol a kulcsok a sztring karakterei, az értékek
pedig az egyes karakterek darabszáma. Például a "Helloworld" bemenetre egy helyes eredmény:
`"r(1)d(1)e(1)w(1)H(1)l(3)o(2)"` (a sorrendtől tekintsünk el).

### 3. gyakorló feladat

Írjon függvényt, amely paraméterként sztringek `ArrayList`-jét kapja, és visszatér egy olyan
listával, amelyik azon sztringeket tartalmazza, amelyek hossza páros.

### 4. gyakorló feladat

Készítsen egy `CheckedSet<T>` generikus osztályt, mely egy halmazt valósít meg. Legyen egy `HashSet<T>` adattagja, melyet a paraméter nélküli konstruktor megfelelően feltölt. Lehessen lekérdezni a halmaz aktuális méretét. Legyen egy `add(T element)` metódusa, mely dobhat `AlreadyContainedException` ellenőrzött kivételt. Ehhez hozzuk létre ezt a kivételosztályt, és dobjuk akkor, ha a halmaz már tartalmaz a megadottal egyenlő elemet; különben tegyük be a halmazba az új elemet. Legyen egy logikai visszatérési értékű `contains(T element)` metódusa, mely ellenőrzi, hogy a halmaz tartalmazza-e a megadott elemet. Egy főprogramban teszteljük le az új osztályt.

### 5. gyakorló feladat

Készítsünk egy `Stack<T>` generikus osztályt, amely egy vermet reprezentál (elem elhelyezése a verem tetején, elem kivétele a verem tetejéről,
legfelső elem lekérdezése, méret lekérdezése, kivételek dobása hibák esetén)!

