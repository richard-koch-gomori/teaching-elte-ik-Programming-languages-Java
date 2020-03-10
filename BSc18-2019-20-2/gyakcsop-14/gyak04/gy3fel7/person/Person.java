

package person;


// primitív típusok: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
// nem primitív típusok: minden más

// pl int i = 2; itt az int primitív, a 2 a stack-en jön létre
// Foo f; itt Foo nem primitív, f csak egy referencia, amivel egy Foo objektumra mutathatunk
// Foo f = new Foo(); itt Foo nem primitív; a new Foo(); miatt a heap-en létrejön egy Foo objektum, az értékadás miatt pedig annak a memóriacíme az f referenciba kerül

// speciális referencia a null; azt jelzi, pl f = null; azt jelenti h az f sehova sem mutat


public class Person
{
    private String firstname, lastname;
    private String occup;
    private Gender gen;
    private int birthYear;

    public Person(String firstname, String lastname, String occup, Gender gen, int birthYear)
    {
        this.firstname = firstname; // mivel a String nem primitív típus ezért a firstname paraméter referencia; itt csak referenciák (memóriacímek) másolódnak
        this.lastname = lastname;
        this.occup = occup;
        this.gen = gen;
        this.birthYear = birthYear; // az int primitív, itt az int érték másolódik
    }

    public String toString()
    {
        return "(" + firstname + "," + lastname + "," + occup + "," + gen + "," + birthYear + ")";
    }

    public boolean equals(Person that)
    {
        // sztringek összehasonlítása:
        // s1.equals(s2) // a String-nek van equals() metódusa, amely összehasonlítja karakterenként

        // s1 == s2
        // mivel s1 és s2 String típusú (azaz referenciák), az s1 == s2 hatására a referenciák hasonlítódanak össze
        // azaz s1 == s2 azt jelenti, h ugyanazon a memóriacímen van-e tárolva s1 és s2
        // nekünk nem erre van szükségünk, hanem arra, hogy karakterenként végignézve ugyanazokat a karaktereket tartalmazza-e a két sztring

        // a birthYear típusa már nem referencia, ezért ezeket a == -vel kell öszehasonlítani (máshogy nem is lehet)
        return this.firstname.equals(that.firstname) && this.lastname.equals(that.lastname) && this.occup.equals(that.occup) && this.gen == that.gen && this.birthYear == that.birthYear;
    }
}

