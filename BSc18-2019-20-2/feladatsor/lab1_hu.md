# Programozási nyelvek (BSc, 18) Java 1. gyakolat


### 1. feladat

Készítsünk programot, amely a billentyűzetről kéri be a felhasználó nevét,
majd üdvözli!

Készítsünk programot, amely a felhasználónevet parancssori argumentumként
kapja, majd üdvözli a felhasználót!

### 2. feladat

Az alábbi Java program feladata, hogy kiírja az 1-től 4-ig lévő számok felét.

Az elvárt kimenet:
0.5
1.0
1.5
2.0
Kiirtam 4 szamot

Javítsa ki a programot!

```java
class Print {
    public static void main() {
        for( int i = 1; i < 4; i++ ) {
            System.out.Println(i/2);
        }
        i = 4;
        System.out.println("Kiirtam " + i + " szamot")
    }
}
```

### 3. feladat

Készítsünk egy programot, amely kiszámolja két egész szám összegét,
különbségét, szorzatát, hányadosát és az osztási maradékot is megadja!
Figyeljünk a nullával való osztásra! (ez esetben ne végezze el az osztást)
A két számot parancssori paraméterként kell megadni. Vizsgáljuk meg azt is,
hogy megfelelő számú parancssori paramétert adtunk–e át!

### 4. feladat

Írjuk meg az n faktoriálisát kiszámoló programot.

### 1. gyakorló feladat

Készítsünk programot, amely a parancssori argumentumában megadott
számról eldönti, hogy tökéletes–e! (A számelméletben tökéletes számnak
nevezzük azokat a természetes számokat, amelyek megegyeznek az önmaguknál
kisebb osztóik összegével (vagyis az összes osztóik összege a szám kétszerese).
Az első négy ilyen szám: 6, 28, 496 és 8128.)

### 2. gyakorló feladat

Módosítsuk az előző megoldásunkat úgy, hogy 1–től a paraméterként megadott
határig minden egész számra vizsgálja a tökéletességet és megadja, hogy abban az
intervallumban mennyi ilyet talált! Ha nem talált egyetlen ilyen számot sem,
akkor írja ki, hogy egyetlen tökéletes szám sincs a megadott intervallumban.


