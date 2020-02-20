

class Complex
{
    public double re, im;

    public double abs()
    {
        return Math.sqrt(re*re + im*im);
    }

    public void add(Complex that)
    {
        re = re + that.re;
        //re += that.re;
        im = im + that.im;
    }

    // a Complex osztálynak akkor is lenne toString()-je, ha itt nem adnánk meg (később tanuljuk miért)
    public String toString()
    {
        return re + " + " + im + "i";
    }
}


class ComplexMain
{
    public static void main(String[] args)
    {
        Complex c = new Complex();
        c.re = 2;
        c.im = 3;
        System.out.println("abs = " + c.abs());

        Complex c2 = new Complex();
        c2.re = 1;
        c2.im = -3;

        System.out.println("c = " + c.toString());

        c.add(c2);
        System.out.println("c = " + c); // c.toString(); hívódik meg
    }
}
