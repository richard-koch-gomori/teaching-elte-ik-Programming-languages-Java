//készítette: Lukács Dávid István

class Complex
{
    private double re, im;

    Complex()
    {
        re=0;
        im=0;
    }

    Complex(double real, double imag)
    {
        re=real;
        im=imag;
    }

    public double getRe(){return re;}
    public double getIm(){return im;}
    public double abs(){return Math.sqrt(re*re + im*im);}

    public void conjugate()
    {
        im = (-1) * im;   
    }

    public void reciprotate()
    {
        double denominator= (re*re + im*im);
        re= (re / denominator);
        im = (-1) * ( im / denominator);
    }

    public Complex div(Complex c)
    {
        Complex r = new Complex();
        double denominator = (c.re*c.re + c.im * c.im);
        r.re= ((re* c.re) + (im * c.im)) / denominator;
        r.im= (im*c.re - re*c.im) / denominator;
        return r;
    }

    public String toString()
    { 
        if(this.getIm()>0)
        {
            return "" + this.getRe() + "+" + this.getIm() + "i";
        }
        if(this.getIm()==0)
        {
            return "" + this.getRe();
        }
        else
        {
            return "" + this.getRe() + this.getIm() + "i";
        }
    }
}

class ComplexMain
{
    public static void main(String[] args)
    {
        Complex c = new Complex(1,2);
        System.out.println("abs = " + c.abs());
        c.reciprotate();
        System.out.println(c.toString());
        Complex res = new Complex(1,1).div(new Complex(1, 1));
        System.out.println(res.toString());
    }
}