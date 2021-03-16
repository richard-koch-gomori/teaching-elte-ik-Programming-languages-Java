

~~~
javadoc IntegerMatrix.java
javadoc Main.java
~~~

JavaDoc formátum:

```
/**
* ...
* ...
*/
```

Hogyan kell kinézniük a Java dokumentációs megjegyzéseknek, ezen belül
a blokkcímkéknek, szövegközi címkéknek (block tags, inline tags)?

@param,@return,@throws etc. -blokkcímke

{@code},{@link} -szövegközi címke


numbers/Rational.java:

~~~{.java}
package numbers;


public class Rational {
    /**
    *  Set {@code this} to {@code this} * {@code that}.
    *  @param that Non-null reference to a rational number,
    *              it will not be changed in the method.
    *  @throws NullPointerException When {@code that} is null.
    */
    public void multiplyWith( Rational that ){
        this.numerator *= that.numerator;
        this.denominator *= that.denominator;
    }
}
~~~

HTML generálás: `javadoc Rational.java`


