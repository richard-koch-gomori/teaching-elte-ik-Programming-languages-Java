

package otherpackage;

// másik csomag (otherpackage)
// a Foo osztály elérése (a packagename csomagból)
// teljesen minősített név (fully qualified name): csomagnév.osztálynév

// ha nem akarjuk mindig kiírni, import-olhatjuk:
import packagename.Foo;


class Main
{
    public static void main(String[] args)
    {
        //packagename.Foo obj = new packagename.Foo(); // teljesen minősített név használata
        Foo obj = new Foo(); // import után így is lehet
        obj.x = 10;
        obj.method();
    }
}

