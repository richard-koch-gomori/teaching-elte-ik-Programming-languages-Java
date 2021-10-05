

Fordítás: `javac circle/CircleMain.java`

A `javac` az egyéb hivatkozott fájlokat is lefordítja, így a `Circle.java` és `Point.java` fájlok is lefordulnak.

Futtatás: `java circle.CircleMain`

- Java-ban minden osztály "tudja magáról" mi a teljesen minősített neve
- pl. a CircleMain osztály teljesen minősített neve `circle.CircleMain`
- a `java` parancs futtatásakor az osztály teljesen minősített nevét kell megadni

- ez alapján ennek a főprogramnak ez a helyes futtatása:  
a `fsor4fel4_a` könyvtárban: `java circle.CircleMain`
- ez viszont **nem**:  
a `fsor4fel4_a/circle` könyvtárban: `java CircleMain`


