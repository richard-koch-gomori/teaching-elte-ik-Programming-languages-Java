

class Main1
{
    public static void main(String[] args)
    {
        System.out.print("Enter a num: ");
        String input = System.console().readLine();
        double d = Double.parseDouble(input);

        // ha vmelyik sqrt() érvénytelen eredménnyel tér vissza
        // pl negatív argumentum miatt
        // akkor a számítássorozat nem áll le, az érvénytelen részeredményből
        // érvénytelen végeredmény állítódik elő
        double res1 = Math.sqrt(d);
        double res2 = 120 - 2*res1;
        double res3 = Math.sqrt(res2);

        // ha itt használom a res3-at, fogalmam sincs róla, hogy valid eredmény van-e benne
        System.out.println("res3 = " + res3);
    }
}

// pl. d = 10000 inputra érvénytelen eredmények számolódnak ki, de a program végigfut


