

## Csomag (package)

csomag ~ könyvtár

A `Point` és `Distance` osztályok a `point2d` csomagban vannak, mert:
- A `Point.java` és `Distance.java` fájlok a `point2d` könyvtárban vannak
- A `Point.java` és `Distance.java` fájlok elején szerepel `package point2d;`

## Fordítás és futtatás

~~~
javac point2d/Point.java
javac point2d/Distance.java
java point2d.Distance 1 2 3 4 5 6
~~~


