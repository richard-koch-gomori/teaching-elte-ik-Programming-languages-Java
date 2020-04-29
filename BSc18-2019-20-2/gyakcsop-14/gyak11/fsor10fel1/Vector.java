import java.util.Objects;

/*
a Java osztályok implicit az Object osztályból származnak
az Object equals() metódusa: public boolean equals(Object that) { return this == that; } // a két objektum referenciájának egyenlősége
a Main.java főprogram HashSet add() metódusa az Object paraméterű equals()-t hívja
a HashSet-be így a (2,3) Vector kétszer kerül be, hiszen más a referenciájuk
ennek javításához a Vector osztályban felül kell definiálni az Object-től örökölt equals()-t
hasonló meggondolások miatt a hashCode() metódust is

equals: mikor tekintünk két objektumot egyenlőnek
hashCode: egész jellegű jellemzője egy objektumnak, amelynek egyenlő objektumok esetén azonosnak kell lennie
*/

class Vector
{
    double[] coords;

    public Vector(double x1, double x2)
    {
        this.coords = new double[2];
        this.coords[0] = x1;
        this.coords[1] = x2;
    }

    public String toString()
    {
        return "(" + this.coords[0] + "," + this.coords[1] + ")";
    }

    @Override
    public boolean equals(Object that) // Object param, mert az Object osztálytől örököltet definiáljuk felül; egyébként ez praktikus is, mert így a Vector bármely objektummal összehasonlítható
    {
        if (that == null) return false;
        if (that == this) return true;
        if (that instanceof Vector) // that dinamikus típusa az Vector vagy Vector-ból származik
        {
            Vector thatVector = (Vector)that; // ilyenkor ez a konverzió biztonságosan elvégezhető
            return this.coords[0] == thatVector.coords[0] && this.coords[1] == thatVector.coords[1]; // itt adjuk meg, mikor tekintjük a két Vector-t egyenlőnek
        }
        else return false; // ha nem is Vector leszármazott, akkor biztosan nem lehetnek egyenlőek
    }

    @Override
    public int hashCode()
    {
        //return (int)(coords[0] + coords[1]);
        //return (int)(7*coords[0] + 19*coords[1]);

        // hashCode() íráskor a hash függvények matematikájával nem foglalkozunk, nem könnyű jó hash függvényt írni
        // az Objects.hash() függvénynek bármennyi és bármilyen típusú adatot odaadhatunk,
        // a paraméterekből generál egy "jobb" hash értéket, mint amit mi most barkácsolnánk
        return Objects.hash(coords[0], coords[1]);
    }
}
