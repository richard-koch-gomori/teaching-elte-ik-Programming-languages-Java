// Peszleg Márton megoldása

import java.util.Arrays;

public class Fsor10fel3
{

    /*public static void swap(Integer[] array,int a, int b)
    {
        Integer tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void swap(Double[] array,int a, int b)
    {
        Double tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }*/

    public static <TYPE> void swap(TYPE[] array,int a, int b)
    {
        TYPE tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public static void main(String[] args)
    {
        Integer[] arr1 = {1,3,5,7,9};
        swap(arr1, 3, 4);
        System.out.println(Arrays.toString(arr1));

        Double[] arr2 = {2.3,5.6,-3.4,12.2};
        swap(arr2, 0, 2);
        System.out.println(Arrays.toString(arr2));
    }
}
