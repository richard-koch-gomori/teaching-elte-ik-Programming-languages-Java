
A megoldásból kihagytuk az `equals()` és `compareTo()` részeket számonkérő feladatokat,
mert a szorgalmi időszakban ezeket nem tanultuk, és a zh-n sem lesz számonkérve.

Fordítás:

Teszt:

Windows:

```
javac -cp .;junit-4.12.jar;hamcrest-core-1.3.jar tests/Tests.java
java -cp .;junit-4.12.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore tests.Tests
```

Linux:

```
javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar tests/Tests.java
java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore tests.Tests
```

Főprogram:

```
javac main/Main.java
java main.Main
```


