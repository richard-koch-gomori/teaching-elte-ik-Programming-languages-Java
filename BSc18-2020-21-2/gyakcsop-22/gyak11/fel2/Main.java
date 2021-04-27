// Gál Gergely megoldása

import java.util.ArrayList;

class Main
{
    public static ArrayList<String> getStrSameBeginningAndEnding(ArrayList<String> Lista)
    {
        ArrayList<String> Megoldas= new ArrayList<String>();
       for(String item : Lista)
       {
           if(item.length()>0 && item.charAt(0)==item.charAt(item.length()-1))
           {
                Megoldas.add(item);
           }
       }
       return Megoldas;
    }

    public static void removeStrDifferBeginningAndEnding(ArrayList<String> Lista)
    {
        Lista.removeIf(item -> (!(item.length()>0 && item.charAt(0)==item.charAt(item.length()-1))));

    }

    public static void main(String[] args) 
    {
        ArrayList<String> Lista = new  ArrayList<String>();
        Lista.add("Sullyed");
        Lista.add("a");
        Lista.add("harossz");
        Lista.add("java");
        Lista.add("c++");
        Lista.add("ada");
        Lista.add("");
        Lista.add("hello world");
        Lista.add("add________hghjAa");
        System.out.println(getStrSameBeginningAndEnding(Lista));
        removeStrDifferBeginningAndEnding(Lista);
        System.out.println(Lista);
    }
}


