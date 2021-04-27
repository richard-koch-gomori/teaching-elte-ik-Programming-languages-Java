// Gál Gergely megoldása

import java.util.LinkedList;

class Main
{
    public static LinkedList<Integer> divisors(int szam)
    {
        LinkedList<Integer> Osztok = new LinkedList<Integer>();
        for(int i=2; i<=szam; i++)
        {
            if(szam%i==0)
            {
                Osztok.add(i);
            }
        }
        return Osztok;
    }
    public static void main(String[] args) 
    {
        /*LinkedList<String> Harossz = new LinkedList<String>();
        Harossz.add("Sullyed");
        Harossz.add("a");
        Harossz.add("harossz");
        System.out.println(Harossz.get(2));
        Integer i=5;
        System.out.println(i);*/
        int asd=60;
        System.out.println(divisors(asd));
    }
}


