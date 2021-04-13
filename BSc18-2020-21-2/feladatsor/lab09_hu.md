# Programozási nyelvek (BSc, 18) Java 9. feladatsor



### 1. feladat

Készítsen `divisors()` néven függvényt, amely a paraméterként kapott pozitív egész szám
osztóit adja vissza egy `LinkedList` adatszerkezetben.

### 2. feladat

Írjon `getStrSameBeginningAndEnding()` néven függvényt, amely foreach ciklussal
bejárja a paraméterként kapott sztringek `ArrayList` adatszerkezetét. A függvény
térjen vissza azon sztringek `ArrayList`-jével, amelyek nem üresek és amelyek első
és utolsó betűje ugyanaz.

Írjon `removeStrDifferBeginningAndEnding()` néven függvényt, amely másolás helyett
törli a paraméterként kapott `ArrayList`-ből azon sztringeket, amelyek üresek vagy
első és utolsó betűje eltér. Foreach ciklus helyett használja az `ArrayList`
`removeIf()` metódusát, amelynek adjon át egy megfelelően megírt lambda kifejezést.

### 3. feladat

Készítsen `minToFront()` néven függvényt, amely egész számok `ArrayList`-jét kapja
paraméterként. A függvény tolja a lista elejére a legkisebb előforduló számot a
többi szám sorrendjét meghagyva. Például a `[4, 65, 45, 44, 76, 2, 98, 72]` inputra
a helyes eredmény: `[2, 4, 65, 45, 44, 76, 98, 72]`. A minimumkereséshez használja a
`Collections.min()` függvényt. Ha a paraméterként kapott lista üres, a függvény
dobjon `IllegalArgumentException` kivételt.

### 4. feladat

Írjon `MultiSet` néven osztályt, mely sztringek multiplicitásos halmazát fogja
reprezentálni: olyan halmazt, amelyben sztringeket tárolunk; ugyanaz a sztring
többször is szerepelhet, ilyenkor a darabszámot is nyilvántartjuk.

A belső reprezentációt valósítsa meg a Java `HashMap` adatszerkezetével, ahol a
kulcsok sztringek, az értékek pedig a kulcsok multiplicitásai.

Az osztálynak legyen paraméter nélküli és paraméteres konstruktora is. A paraméteres
konstruktor egy már létező `HashMap` adatszerkezet tartalmát másolja le. Írjon
`getData()` metódust, amely visszaadja a hívónak a halmazt reprezentáló `HashMap`
adatszerkezetet. Vigyázzon arra, hogy a metódus ne szivárogtassa ki az osztály belső
állapotát.

Írjon `put()` néven metódust, amely a fentiek figyelembevételével hozzáad egy
sztringet a multiplicitásos halmazhoz.

Írjon `intersect()` néven metódust, amely paraméterként egy `MultiSet` referenciát
kap, és előállítja az aktuális és a paraméterként kapott `MultiSet` halmazok
metszetét. Multiplicitásos halmazok esetén a metszet azokat az elemeket tartalmazza,
amelyek mindkét halmazban megtalálhatóak, a metszetbeli multiplicitás pedig a két
halmazban lévő multiplicitások minimuma. A metódus az aktuális objektumon ne változtasson;
az eredmény egy új `MultiSet` objektum, amely referenciájával térjen vissza.

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
pedig az egyes karakterek darabszáma. Például a "Helloworld" inputra egy helyes eredmény:
"r(1)d(1)e(1)w(1)H(1)l(3)o(2)" (a sorrendtől tekintsünk el).

### 3. gyakorló feladat

Írjon függvényt, amely paraméterként sztringek `ArrayList`-jét kapja, és visszatér egy olyan
listával, amelyik azon sztringeket tartalmazza, amelyek hossza páros.

