// a Main.java a packagename csomag része mert:
// - Main.java a packagename könyvtárban van
// - a package kulcsszó mögött packagename név van

// fordítás és futtatás a packagename könyvtárat tartalmazó könyvtárban:
// javac packagename/Main.java
// java packagename.Main

package packagename;


class Main
{
    public static void main(String[] args)
    {
        Foo obj = new Foo();
        obj.x = 10;
        obj.method();
    }
}

