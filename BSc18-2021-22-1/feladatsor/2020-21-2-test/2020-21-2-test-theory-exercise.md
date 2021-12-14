# Programozási nyelvek (BSc, 18) Java zh elméleti feladatsor



### 1. kérdés

Mit jelent a túlterhelés kifejezés?

- Egy tömböt olyan számmal indexelünk, ami nem kisebb, mint a tömb mérete.
- Egy aritmetikai művelet eredménye túl nagy, nem fér bele a változóba.
- Ugyanarra az objektumra több referenciaváltozó segítségével hivatkozunk.
- Egy osztályban ugyanolyan nevű, de különböző paraméterezésű metódusok vannak.

### 2. kérdés

Melyik hoz létre altípus kapcsolatot, az `extends` vagy az `implements`?

- Csak az `extends`.
- Csak az `implements`.
- Mindkettő.
- Csak az osztályokra alkalmazott `extends`.

### 3. kérdés

Mi a dinamikus típusa az `a` változónak a program végén?

~~~{.java}
class A {}
class B extends A {}
class C extends B {}
class D extends C {}
class Main {
    public static void main( String[] args ){
        C c = new D();
        A a = (B)c;
    }
}
~~~

- A
- B
- C
- D

### 4. kérdés

Mit nevezünk ellenőrzött kivételnek (checked exception) a Javában?

- Azokat a kivételeket, amelyeket a metódusunk lekezelt egy `try`-`catch` utasítással.
- Azokat az `Exception`öket, amelyek nem `RuntimeException`ök.
- Azokat a kivételeket, amelyeket nem kezeltünk le `try`-`catch` utasítással, de feltüntettünk a metódusunk `throws` klózában.
- Azokat a kivételeket, amelyek használhatók a try-with-resources utasításban.

### 5. kérdés

Miért fontos az auto-(un)boxing a generikusok használatához? Fejtsd ki 5-10 mondatban, példákkal illusztrálva!

### 6. kérdés

Mi a kapcsolat az öröklődés és a konstruktorok között? Fejtsd ki 5-10 mondatban, példákkal illusztrálva!

### 7. kérdés

Mit fejez ki az `Iterable` `interface?` Milyen nyelvi lehetőséget indukál? Fejtsd ki 3-5 mondatban, példákkal illusztrálva!