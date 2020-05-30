# Programozási nyelvek (BSc, 18) Java 2019/20/2 elővizsga


### 1. kérdés

Miért kapunk fordítási hibát erre az osztályra?

~~~{.java}
abstract class Strange {
    private int position = 0;
    public int position( int offset ){
        position += offset;
        return position;
    }
    public static Strange make(){
        return new Strange();
    }
}
~~~

- Az absztrakt osztály nem példányosítható.
- Absztrakt osztályban nem lehet adattag.
- Absztrakt osztályban a metódusoknak absztraktnak kell lenniük.
- Egy absztrakt osztályban lennie kell absztrakt metódusnak.

### 2. kérdés

Tekintsük az alábbi típusdefiníciókat.

~~~{.java}
class Device {}
class Phone extends Device implements Callable {}
class iPhone extends Phone implements Fancy, Callable {}
interface Callable {}
interface Fancy {}
interface ReallyUseful extends Callable {}
~~~

Melyik állítás igaz az alábbiak közül?

`ReallyUseful` altípusa `Phone`-nak  
`Phone` altípusa `Device`-nak

- A második
- Az első
- Mindkettő
- Egyik sem

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

- D
- A
- B
- C

### 4. kérdés

Lefordul az alábbi program? Ha igen, mit ír ki?

~~~{.java}
public class Pair {
    public final int left, right;
    public Pair( int left, int right ){
        this.left = left; this.right = right;
    }
    public boolean equals( Pair that ){
        return that != null && left == that.left && right == that.right;
    }
    public static void main( String[] args ){
        Object origin = new Pair(0,0);
        System.out.println( new Pair(0,0).equals(origin) );
    }
}
~~~

- Lefordul, hamisat ír ki.
- Lefordul, igazat ír ki.
- Nem fordul le, hibás felüldefiniálás.
- Nem fordul le, kimaradt a `@Override` annotáció.

### 5. kérdés

Mi a hatása a `new Time()` példányosításnak?

~~~{.java}
public class Date {
    private int year = 1970, month = 1, day = 1;
    public Date( int year, int month, int day ){
        this.year = year; this.month = month; this.day = day;
    }
}
public class Time extends Date {
    private int hour = 12, minute = 0; 
}
~~~

- Fordítási hiba: hibás konstruktor a `Time` osztályban.
- Fordítási hiba: nincs konstruktor a `Time` osztályban.
- Futási hiba: nincs konstruktor a `Time` osztályban.
- A létrejövő objektum `year` mezője `1970` lesz.

### 6. kérdés

Meghívható-e a `store()` metódus a "John" paraméterrel?

~~~{.java}
public void store( Object value ){
    file.println(value);
}
~~~

- Igen, mert a paraméter dinamikus típusa a statikus típusnak altípusa.
- Igen, mert a paraméter statikus típus a dinamikus típusnak altípusa.
- Igen, mert a paraméter dinamikus típusa a statikus típusnak nem altípusa.
- Nem, mert a paraméter statikus típus a dinamikus típusnak nem altípusa.

### 7. kérdés

Mit ír ki az alábbi program?

~~~{.java}
class WeLoveThis {
    static int[] exchange( int[] array ){
        array[0] = 0;
        array = new int[]{5,4,3,2,1};
        return new int[]{2,2,2,2,2};
    }
    public static void main( String[] args ){
        int[] array = {1,2,3,4,5};
        exchange(array);
        System.out.println(array[0]);
    }
}
~~~

- 0
- 1
- 2
- 5

### 8. kérdés

Mi igaz erre a programra?

~~~{.java}
public class Time {
    private int[] values = new int[2];   // hours and minutes
    public int getHour(){ return values[0]; }
    public int getMinute(){ return values[1]; }
    public Time( int[] values ){
       if( values[0] >= 0 && values[0] < 24 && values[1] >= 0 && values[1] < 60 ){ 
           this.values = values;
       } else throw new IllegalArgumentException();
    }
}
~~~

~~~{.java}
class Main {
    public static void main( String[] args ){
        int[] current = {6,20,0};  // hours, minutes, seconds
        Time wakeUp = new Time(current);
        current[0] = 3;  // messze még a hajnal
        if( current[0] == wakeUp.getHour() && current[1] == wakeUp.getMinute() ){
            System.out.println("Rrrrrring!");
        }
    }
}
~~~

- Rosszul készítettük el a programot, ezért kiiíródik, hogy "Rrrrrring!"
- Nem íródik ki semmi.
- Fordítási hiba: egy 2 hosszú tömbnek megpróbálunk egy három hosszút értékül adni.
- Futási hiba: egy 2 hosszú tömbnek megpróbálunk egy három hosszút értékül adni.

### 9. kérdés

Hol használható az `warm.Owen.minTemperature` kifejezés? A `warm.Stove` osztályban vagy a `cool.Fridge` osztályban?

~~~{.java}
package warm;
class Owen {
    static final int minTemperature = -273;  // absolute zero
}
~~~

- Csak a `warm.Stove` osztályban.
- Csak a `cool.Fridge` osztályban.
- Mindkettőben.
- Egyikben sem.

### 10. kérdés

Mi igaz erre a programra?

~~~{.java}
public class Holder {
    public String value;
    public Holder( String value ){
        this.value = value;
    }
}

class Main {
    private static final Holder name = new Holder("Tom");
    public static void main( String[] args ){
         name.value = "Jerry";
    }
}
~~~

- A `Main.name.value` értéke "Jerry" lesz.
- Fordítási hiba a `Main` 4. sorában az értékadásra: a `name.value` immutable (`String` típusú), ezért nem adhatunk értéket neki.
- Fordítási hiba a `Main` 4. sorában az értékadásra: a `name` `final`, ezért nem adhatunk értéket neki.
- Futási hiba a `Main` 4. sorában az értékadásra: a `name.value` immutable (`String` típusú), ezért nem adhatunk értéket neki.

### 11. kérdés

Magyarázza el néhány mondatban és egy példával, mit jelent a dinamikus kötés!

### 12. kérdés

Mik az ellenőrzött kivételek (checked exception)?

### 13. kérdés

Miért van szükség `interface`-ekre? Miért nem elegendő `abstract` osztályokat használni helyettük? Mi a különbség a kettő között?

### 14. kérdés

Mi a különbség a lusta és mohó logikai operátorok között? Milyen esetekben válik érzékelhetővé a különbség? Mutassa be példákon!

### 15. kérdés

Magyarázza el röviden a Mark-and-Sweep szemétgyűjtő működését!


