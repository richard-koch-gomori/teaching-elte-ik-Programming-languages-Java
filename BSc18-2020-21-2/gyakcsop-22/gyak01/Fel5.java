
class Fel5
{
    public static void main(String[] args)
    {
        for( int i = 1; i <= 4; i++ )
        {
            // i/2.0 kell, hogy lebegőpontos osztás történjen
            System.out.println(i/2.0);
        }
        System.out.println("Kiirtam 4 szamot");

        /*
        double x = 3.141592;
        System.out.println("x = " + Math.floor(x));
        System.console().printf("x = %.4f", x);
        */
    }
}

