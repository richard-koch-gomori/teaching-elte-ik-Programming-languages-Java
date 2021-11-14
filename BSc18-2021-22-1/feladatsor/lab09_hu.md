# Programozási nyelvek (BSc, 18) Java 9. feladatsor



### 1. feladat

Írjon `swap()` néven generikus metódust, amely megcseréli a paraméterként kapott egydimenziós
tömb két tetszőleges elemét.

### 2. feladat

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

### 3. feladat

Írjon `getStrSameBeginningAndEnding()` néven függvényt, amely foreach ciklussal
bejárja a paraméterként kapott sztringek `ArrayList` adatszerkezetét. A függvény
térjen vissza azon sztringek `ArrayList`-jével, amelyek nem üresek és amelyek első
és utolsó betűje ugyanaz.

Írjon `removeStrDifferBeginningAndEnding()` néven függvényt, amely másolás helyett
törli a paraméterként kapott `ArrayList`-ből azon sztringeket, amelyek üresek vagy
első és utolsó betűje eltér. Foreach ciklus helyett használja az `ArrayList`
`removeIf()` metódusát, amelynek adjon át egy megfelelően megírt lambda kifejezést.

### 1. gyakorló feladat

Készítsen egy `CheckedSet<T>` generikus osztályt, mely egy halmazt valósít meg. Legyen egy `HashSet<T>` adattagja, melyet a paraméter nélküli konstruktor megfelelően feltölt. Lehessen lekérdezni a halmaz aktuális méretét. Legyen egy `add(T element)` metódusa, mely dobhat `AlreadyContainedException` ellenőrzött kivételt. Ehhez hozzuk létre ezt a kivételosztályt, és dobjuk akkor, ha a halmaz már tartalmaz a megadottal egyenlő elemet; különben tegyük be a halmazba az új elemet. Legyen egy logikai visszatérési értékű `contains(T element)` metódusa, mely ellenőrzi, hogy a halmaz tartalmazza-e a megadott elemet. Egy főprogramban teszteljük le az új osztályt.

### 2. gyakorló feladat

Készítsünk egy `Stack<T>` generikus osztályt, amely egy vermet reprezentál (elem elhelyezése a verem tetején, elem kivétele a verem tetejéről,
legfelső elem lekérdezése, méret lekérdezése, kivételek dobása hibák esetén)!

