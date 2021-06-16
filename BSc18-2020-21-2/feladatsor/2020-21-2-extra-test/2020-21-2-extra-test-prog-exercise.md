# Programozási nyelvek (BSc, 18) Java pótzh programozási feladat



## Szabályok

Az alábbi feladatleírásban azon nyelvi elemek (osztályok, metódusok stb)
leírása szerepel, amelyeknek kötelező megjelennie a megoldásban. A
megnevezetteken kívül további rejtett adattagok és metódusok, valamint nyilvános
setter/getter metódusok felvétele megengedett. Ha a feladatleírásban meg van
adva egy nyelvi elem neve, kötelező azt használni. A nyelvi szabályok mellett
betartandóak a Java nyelv konvenciói is.

Ha bármilyen kérdés, észrevétel felmerül, azt az MS Teams alkalmazáson keresztül
az oktatóknak vagy a gyakorlatvezetőnek kell jelezni, **nem** a diáktársaknak!

Az elkészített megoldásokat **generált fájlok (.class, .jar) nélkül** a Canvas
felületen kérjük beadni. A **.jar fájlokat sem kérjük** beadni. Az elkészített
megoldást csomagoljuk zip archívumba. A zip-fájlban a csomagoknak megfelelő
könyvtárak is legyenek eltárolva.
Linux alatt az alábbi paranccsal hozhatunk létre zip-fájlt:

~~~
zip -r megoldas.zip *
~~~

A Canvas-be lehetőség van többször feltölteni és beadni megoldást.
Az utoljára beadott megoldást fogjuk értékelni.

Használható segédanyagok:

- Letölthető zip fájl: [https://people.inf.elte.hu/kgomoririchard/java/base_multiplayer.zip](https://people.inf.elte.hu/kgomoririchard/java/base_multiplayer.zip),
  amely tartalmazza a junit tesztelő környezet
  jar fájljait, valamint a `users/` könyvtárban a mintaként adott szöveges
  inputfájlokat.
- [Java dokumentáció](https://bead.inf.elte.hu/files/java).
- Legfeljebb egy üres lap és toll.

## A feladat összefoglaló leírása

Ahogy a tavalyi zárthelyi dolgozatban is láttuk, egy MultiPlayer (többszereplős) játékban
játékosok (`Player`) vannak. Idén a játékosok mellett `NPC`-k is részt vesznek a játékban
(nem irányítható karakterek), valamint implementálunk egy `Server` logikát, amely a
játéktéren (szerver) jelenlévő résztvevőket tárolja. A főprogramban egy korábban már regisztrált
játékos bejelentkezését fogjuk implementálni. A játékos csak akkor léphet be a szerverre,
ha a korábbi regisztrációjakor megadott jelszót adja meg.

## Caesar-rejtjel (4.5 pont)

A játékosok adatait szöveges fájlban tároljuk, így kiírásra kerül a játékos jelszava is,
ami nem egy biztonságos módszer, mert a jelszót bárki megismerheti, aki hozzáfér a
szöveges fájlhoz. Az informatikában a jelszavakat titkosítva szoktuk tárolni, aminek az a
lényege, hogy az eredeti jelszót (ami egy sztring) átalakítjuk oly módon, hogy ránézésre
ne legyen felismerhető, mi volt az eredeti jelszó, azonban egy titkosítási kulcs ismeretében
az visszafejthető legyen. A Caesar-rejtjelezés egy egyszerű titkosítási eljárás, amely
elnevezést Julius Caesar után kapta, aki ennek segítségével kommunikált tábornokaival.
(A Caesar-rejtjel egyszerűsége miatt alkalmatlan informatikai használatra, azonban komolyabb
számelméleti ismeretek hiányában most megelégszünk ezzel.)

Legyen adott egy eltolás (`shift`, nemnegatív egész szám). A Caesar-rejtjel a titkosítani
kívánt szöveg minden betűjét `shift`-tel tolja arrébb az ABC-ben. Legyen például `shift=1`,
ekkor a "password" sztring Caesar-rejtjelezése:

- a "p" utáni betű "q"
- az "a" utáni betű "b"
- ...
- a "d" utáni betű "e"

Így a rejtjelezett szöveg "qbttxpse", amit a kriptográfiában cipher-nek neveznek. A "qbttxpse"
szöveg ismeretében még nem tudja valaki megfejteni az eredeti sztringet, azonban a `shift=1`
ismeretében vissza tudja fejteni, hogy a "password" volt a bemenet.

Írjon `util.Cipher` osztályt, amely a Caesar-rejtjelezéshez szükséges titkosító és visszafejtő
függvényeket tartalmaz. Írjon `encrypt()` néven statikus függvényt, amely paraméterként egy
titkosítandó szöveget és `shift`-et kap paraméterként, majd visszatér a Caesar-rejtjelezett szöveggel.
Írjon `decrypt()` néven statikus függvényt, amely egy rejtjelezett szöveget és `shift`-et kap
paraméterként, majd visszatér az eredeti szöveggel.

A `shift` egyik esetben sem lehet negatív, ekkor a függvények dobjanak `IllegalArgumentException`
kivételt. Ha egy `char ch;` változóban egy karakter van, akkor `ch + 1` a rákövetkező karakter
kódja, `(char)(ch + 1)` pedig a rákövetkező karakter. Feltételezhetjük (azaz nem kell ellenőrizni),
hogy az eltolt karakterek érvényes karakterek maradnak.

Az `encrypt()` és `decrypt()` függvények úgy állítsák elő az eredményüket, hogy
közben ne hozzanak létre felesleges sztring példányokat.

Írjon unit teszteket a következő elvárások tesztelésére:

- Az `encrypt()` függvény negatív `shift` esetén `IllegalArgumentException` kivételt dob.
- Az `encrypt()` függvény 0-nál nagyobb `shift` esetén helyes eredménnyel tér vissza.
- A `decrypt()` függvény 0-nál nagyobb `shift` esetén helyes eredménnyel tér vissza.

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

## Résztvevők (Participants): Player és NPC (3.5 pont)

Írjon `game.Participant` néven osztályt, amely egy játékban résztvevőt fog reprezentálni, a
`Player` és `NPC` osztályok szülőosztálya. Minden `Participant`-nak van neve (`name`,
ami egy sztring), valamint a névhez tartozik getter metódus, amit a leszármazott
osztályok **nem** definiálhatnak felül.

Írjon `game.Player` néven osztályt, ami leszármazik a `game.Participant` osztályból, és
egy játékost reprezentál. Egy játékosnak a nevén túl van IP-címe is (`ip`, ami egy sztring),
valamint tartozik hozzá getter metódus. Írjon konstruktort, amely tárolja a játékos
nevét és IP-címét.

Írjon `game.NPC` néven osztályt, ami leszármazik a `game.Participant` osztályból, és egy
nem irányítható karaktert reprezentál. (Az `NPC`-k (bot-ok) olyan résztvevők egy MultiPlayer-es
játékban, amelyek úgy néznek ki mint a játékosok, azonban nem igazi játékos van mögötte,
hanem valamilyen előre rögzített mozdulatsorozatot (animációt) hajt végre 
(pl. járművet vezet, etc.)) Írjon `game.Animation` néven felsorolt típust, amelynek értékei:
`HELP`, `HIDE`, `ATTACK`, `DEFEND`. Egy `NPC`-nek van egy létrehozás után már módosíthatatlan
`animation` adattagja (`game.Animation` típusú). A konstruktor tárolja az `NPC` nevét és az animációt
(`animation`). Az `animation` adattaggal a továbbiakban nem foglalkozunk; csak egy tárolt információ.

## Szerver (16 pont)

A játéktér színtere a szerver, ahová bárki beléphet, regisztrálhat a szerverre, a későbbiekben
pedig csak érvényes bejelentkezést követően léphet be újra a szerverre. Ebben a ZH-ban mi csak
a bejelentkezést és szerverre belépést fogjuk implementálni. Minden szerverre belépett résztvevőnek
(`Participant`) van egy sorszáma (ID), ami egy nemnegatív egész szám. (A játék folyamán arra
szokták használni ezt az ID-t, hogy a játékosok tudjanak egymásra hivatkozni. Ebben a ZH-ban
mi csak megkonstruálunk egy ilyen ID-t, de felhasználni csak kiíratáskor (`toString()`) fogjuk.)
Az első becsatlakozott résztvevő ID-ja 0, a következőé 1, a következőé 2, a következőé 3, és
így tovább. Ha az 1-es és 3-as ID-jú résztvevő kilép a szerverről (ekkor a szerveren lévő
játékosok ID-jai: 0 és 2), majd utána csatlakozik egy újabb résztvevő, akkor ő az 1-es ID-t
kapja meg. Az ID-t a szerver tárolja a résztvevőkről (tehát **nem** a `Participant`
osztályban kell tárolni).

Írjon `game.Server` néven osztályt, amely a szerverre belépett résztvevőket és azok ID-ját tartja
számon. A `Server` egy `HashMap<>` adattagjában nyilvántartja, hogy melyik ID-hoz melyik résztvevő
(`Participant`) tartozik.

A feladat megoldása során előnyösebb résztvevő ID szerint sorban bejárni a `HashMap<>`-et.
Vegyük észre, hogy ekkor a ciklus felső határa nem a `HashMap<>` mérete minusz 1, hiszen például,
ha a szerveren a 0 és 2-es ID-jú játékosok vannak, akkor a `HashMap<>` mérete 2, azaz a
2-es ID-jú játékost figyelmen kívül hagynánk. Ezt a problémát orvosoljuk úgy, hogy a `Server`
osztály a privát `currentMaximumID` (egész szám) adattagjában mindig tárolja, hogy mi az
éppen aktuális legnagyobb résztvevő ID.

Írjon `getParticipantFromName()` néven metódust, amely paraméterként egy játékosnevet vár,
és visszatér a szerver résztvevő-nyilvántartásából a névhez tartozó résztvevő `Participant`
referenciájával. Ha nincs ilyen nevű játékos a szerveren, a visszatérési érték legyen `null`.
(Segítség: Járja be index szerint a `Server` `HashMap<>`-jét, ahol a ciklus
felső határa `currentMaximumID`. Ha az `i`. indexű elemhez nem tartozik `Participant`,
akkor a ciklusmag kihagyásával folytassuk a ciklus következő iterációjával. Ha az `i`. indexű
elemhez van `Participant`, akkor vizsgáljuk meg, hogy annak `getName()`-je ugyanaz a sztring-e
mint a paraméterként kapott; ha igen, térjünk vissza ezzel a `Participant`-tal; ha a ciklus
visszatérés nélkül lefut, térjünk vissza `null` referenciával.)

Írjon `addParticipant()` néven metódust, amely paraméterként egy résztvevőt (`Participant`)
vár, és hozzáadja a szerver résztvevő-nyilvántartásához a résztvevőt, majd sikeres hozzáadás esetén
visszatér annak ID-jával. Ha a kapott `Participant` `null` referencia, a függvény dobjon
`IllegalArgumentException` kivételt.
Amennyiben a szerver résztvevő-nyilvántartásában már szerepel a kapott
`Participant`, vagy ha nem szerepel, de ugyanilyen néven már szerepel valaki más
(célszerű lehet használni a korábban megírt `getParticipantFromName() metódust`), akkor dobjon
`util.ServerException` kivételt valamilyen informatív hibaüzenettel. A `util.ServerException` kivétel egy
saját, ellenőrzött kivételosztály legyen, és lehessen paraméter nélkül és paraméteresen is konstruálni.
A paraméteres konstruktor meghívja a szülőosztály konstruktorát a paraméterként kapott
hibaüzenettel (`String`).

Az `addParticipant()` fogja kiosztani minden belépett résztvevőnek az ID-ját, azonban fontos,
hogy ez az ID később is ugyanaz maradjon, mint amit belépéskor kapott a résztvevő, így pl. egy
résztvevő kilépésekor (`removeParticipant()`) a többi résztvevő ID-ja **nem** változhat meg.
A kilépés miatt felszabaduló ID-kat a metódus újra kiosztja a jövőben becsatlakozó résztvevőknek.

Írjon `removeParticipant()` néven metódust, amely paraméterként a résztvevő ID-ját kapja,
és ha tényleg van ilyen résztvevő a szerveren, akkor törli a `HashMap<>` nyilvántartásból
az ID-t és a `Participant` referenciát is, ellenkező esetben `ServerException` kivételt dob.
Résztvevő törléskor csökkenhet a `currentMaximumID`.
Ha szükséges, frissítse a `currentMaximumID` adattag értékét úgy, hogy a szerveren
fent lévő résztvevők közül a legnagyobb ID-t tartamazza.

Definiálja felül a `toString()` metódust: térjen vissza a szerveren lévő résztvevőkkel úgy, hogy először a
résztvevő ID-ja, kettőspont, majd a résztvevő neve szerepel szóközzel elválasztva (a résztvevők
is lehetnek szóközzel elválasztva). A résztvevők ID szerint növekvő sorrendben következzenek; az utolsó résztvevő neve után ne legyen szóköz.
Ha egy ID már nem tartozik résztvevőhöz, akkor az a sorszám ne jelenjen meg a `toString()`
eredményében. Ügyeljen arra, hogy úgy állítsa elő az eredményt, hogy közben
ne hozzon létre felesleges sztring példányokat.

Írjon unit teszteket a következő elvárások tesztelésére:

- Az `addParticipant()` 4 csatlakozott játékos, és 1 `NPC` esetén a 0, 1, 2, 3, 4 ID-kat osztja ki.
Ha a 3-as és 4-gyes résztvevő kilép a szerverről (`removeParticipant()`), majd két újabb nevű játékos
csatlakozik a szerverhez, akkor a két új játékos a 3-as és 4-gyes ID-kat kapja meg.
- Az `addParticipant()` metódus `ServerException` kivételt dob, ha ugyanazt a játékosnevet
többször felhasználjuk.
- A `Server` osztály `toString()`-je helyesen adja meg a szerveren fent tartózkodókat egy
`removeParticipant()` hívás **előtt** és **után** is.
- A `Server` osztály `toString()`-je helyesen adja meg a szerveren fent tartózkodókat, majd
minden résztvevő kilépése után üres sztringgel tér vissza.

## Főprogram (6 pont)

Tekintsük az alábbi hiányos `main.Main` főprogramot, amely feladata a következő:

- Egy `shift` módosíthatatlan, statikus adattagban tárolja a programunkban használt eltolás értéket,
ami most legyen 3.
- Létrehoz egy `Server` objektumot.

Ezután végtelen ciklusban a következő tevékenységet végzi:

- Beolvas a billentyűzetről egy nevet, ami egy résztvevő nevét (`name`) jelenti. Megnyitja a
`users/name.txt` szöveges fájlt. Amennyiben a fájl nem nyitható meg, közli a felhasználóval,
hogy ilyen játékos még nem regisztrált a szerverre.
- Beolvassa a billentyűzetről a felhasználótól a játékos jelszavát, majd `shift`-tel előállítja
a Caesar-rejtjelezett szöveget.
- Beolvassa a `users/name.txt` szöveges fájlból a korábban már regisztrált játékos IP-címét és jelszavát.
Ezek külön sorban helyezkednek el, (első sorban a játékos IP-címe, második sorban a jelszava
Caesar-rejtjelezve). Feltehető, hogy az inputfájl helyesen van kitöltve.
- Összehasonlítja a két Caesar-rejtjelezett szöveget, majd amennyiben a rejtjelezett sztringek ugyanazok,
megkonstruál egy `Player` objektumot `name`-mel és a szöveges fájlból beolvasott IP-címmel, majd hozzáadja
ezt a játékost a szerverhez. Amennyiben a hozzáadáskor valamilyen kivétel lép fel, akkor annak az üzenetét
kiírja a képernyőre.
- Amennyiben a rejtjelezett sztringek eltérnek, valamilyen informatív hibaüzenettel közli a felhasználóval,
hogy a beírt jelszó hibás.
- Minden bejelentkezési kísérlet után kiírja a szerveren tartózkodókat a képernyőre.
- Ha `ServerException` kivétel lép fel, a ciklusmagon belül elkapja, majd kiírja a kivétel üzenetét.

Az alább közölt kód hiányos, a hiányzó részeket meg kell írni! A már megírt részek módosíthatóak, de
szándékos hibákat **nem** tartalmaznak.

~~~{.java}
public class Main
{
    // ...

    public static void main(String[] args)
    {
        // ...

        while (true)
        {
            System.out.print("Enter name: ");
            String name = System.console().readLine();

            File user = new File("users/" + name + ".txt");
            try (BufferedReader br = new BufferedReader(new FileReader(user)))
            {
                // ...
            }
            catch (FileNotFoundException exc)
            {
                // ...
            }
            catch (IOException exc)
            {
                System.out.println("Error: IO error occured: " + exc.getMessage());
            }
            catch (ServerException exc)
            {
                // ...
            }

            // ...
        }
    }
}
~~~

|játékos  |jelszó  |
|---------|--------|
|Daniel   |password1|
|Richard  |password2|
|Tamas    |password3|
|Zorror   |password4|
