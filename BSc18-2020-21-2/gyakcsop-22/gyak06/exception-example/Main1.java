

class Main1
{
    public static void main(String[] args)
    {
        System.out.print("Enter a num: ");
        String input = System.console().readLine();
        double d = Double.parseDouble(input);

        double res1 = Math.sqrt(d);
        double res2 = 120 - 2*res1;
        double res3 = Math.sqrt(res2);

        System.out.println("res3 = " + res3);
    }
}


