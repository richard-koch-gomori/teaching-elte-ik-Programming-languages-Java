import java.util.Arrays;


public class Main
{
    // generikus metódus
    public static <TYPE> void swap(TYPE[] arr, int i, int j)
    {
        TYPE tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args)
    {
        Integer[] arr1 = {3, 6, 8};
        swap(arr1, 0, 2);
        System.out.println(Arrays.toString(arr1));

        Double[] arr2 = {2.71, 3.14, 5.2, 7.8};
        swap(arr2, 0, 2);
        System.out.println(Arrays.toString(arr2));
    }
}

