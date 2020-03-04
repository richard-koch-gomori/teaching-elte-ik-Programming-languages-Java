

package main;

import person.*;


class Main
{
    public static void main(String[] args)
    {
        Person p = new Person("AAA", "BBB", "occ", Gender.MALE, 2000);
        Person p2 = new Person("AAA2", "BBB2", "occ2", Gender.FEMALE, 2002);
        Person p3 = new Person("AAA", "BBB", "occ", Gender.MALE, 2000);
        System.out.println(p);
        System.out.println(p2);
        if (p.equals(p3))
        {
            System.out.println("Ugyanaz a szemely");
        }
        else
        {
            System.out.println("Nem Ugyanaz a szemely");
        }

        if (p.equals(p2))
        {
            System.out.println("Ugyanaz a szemely");
        }
        else
        {
            System.out.println("Nem Ugyanaz a szemely");
        }
    }
}
