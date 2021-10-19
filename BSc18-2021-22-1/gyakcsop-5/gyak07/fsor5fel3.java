/*
a típusoknak 2 csoportja van:
- primitív típus: csak ezek, és nincs más primitív típus: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
- nem primitív típus: minden más, pl. String, én Foo osztályom is egy nem primitív típus

nem primitív típusú változó/adattag == referencia
referencia: memóriacímet tartalmaz, (lényegében a C pointer-einek felel meg)

a primitív típusú lokális változók a stack-en tárolódnak
new-val létrehozott objektum mindig a heap-en tárolódik

null: null referencia, sehova sem mutat
*/


class Foo {
    private int x;

    public Foo(int x) {
        System.out.println("Foo ctor");
        this.x = x; // this: referencia, mindig az aktuális objektumra mutat (aktuális objektum: az az objektum, amin a metódust meghívták)
    }
}

class Main {
    public static void main(String[] args) {
        int counter = 10;       // (1)

        Foo obj;                // (2)
        obj = new Foo(5);       // (3) // new Foo(5): a heap-en foglal egy Foo objektumot, az x adattagjában tárolja az 5-ös értéket, és az obj-ba belekerül az objektum kezdő memóriacíme

        Foo obj2 = new Foo(7);  // (4)
        obj2 = obj;             // (5) // elveszítjük a Foo(7) referenciáját; ekkor a szemétgyűjtő (garbage collector) tudomásul veszi, hogy a Foo(7) objektum törölhető, és valamikor majd törli

        // ...
    }
}




/*
stack                                      heap

(1)
counter=10

(2)
counter=10
obj

(3)
counter=10
obj -------------------------------------> Foo { x = 5 }

(4)
counter=10
obj -------------------------------------> Foo { x = 5 }
obj2 ------------------------------------> Foo { x = 7 }

(5)
counter=10
obj, obj2 -------------------------------> Foo { x = 5 }
                                           Foo { x = 7 }



