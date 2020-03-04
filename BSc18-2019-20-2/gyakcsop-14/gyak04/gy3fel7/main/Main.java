

package main;

import person.*;


public class Main
{
    public static void main(String[] args)
    {
        Person p1 = new Person("AAA", "BBB", "oc", Gender.MALE, 2000);
        Person p2 = new Person("AAA2", "BBB2", "oc2", Gender.FEMALE, 1999);
        Person p3 = new Person("AAA", "BBB", "oc", Gender.MALE, 2000);
        System.out.println(p1);
        System.out.println(p2);

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));

        //p1 = p2; // referenciák értékadása: p1 objektum referenciája megsemmisül,
        // az eredeti p1 által mutatott obkektumnak így elvesztem a referenciáját, azt visszaszerezni már nem tudom (nincs elmentve semelyik változóba)
        // a garbage collector számon tartja, h mely objektum referenciáját ismeretjük; amelyek referenciáját elveszítjük, azt vmikor törli

        // nincs delete p1;
        // hogyan törölhet a Java programozó? alapesetben sehogy
        // a p1 = null; értékadással elveszítjük a p1 referenciáját (feltéve h nincs másik változóban is tárolva (aka aliasing)), a garbage collector vmikor törölni fogja

        //Person p = new Person("AAA", "BBB", "oc", Gender.MALE, 2000);
        //Person p2; // nem keletkezik objektum a heap-en, ez csak egy referencia
        //p2 = p; // itt sem keletkezik objektum a heap-en, de ugyanarra az objektumra van egy másik (p2) referenciám is
        //p2.birthYear = 3000;
        //System.out.println("p.birthYear = " + p.birthYear); // 3000-et ír ki, mert p és p2 referencián keresztül ugyanazt az objektumot értük el
    }
}

