

class Complex
{
    public double re, im;

    public double abs()
    {
        return Math.sqrt(re*re + im*im);
    }
}

class ComplexMain
{
    public static void main(String[] args)
    {
        Complex c = new Complex();
        c.re = 2;
        c.im = -3;
        System.out.println("abs = " + c.abs());
    }
}
