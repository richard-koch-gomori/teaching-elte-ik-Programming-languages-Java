

public class Main
{
    public static void main(String[] args)
    {
        int[] linearData = {0, 0, 1, 2, 3, 4};

        /*
        int[] linearData = new int[6];
        linearData[0] = 0;
        linearData[1] = 0;
        linearData[2] = 1;
        linearData[3] = 2;
        linearData[4] = 3;
        linearData[5] = 4;
        */

        IntegerMatrix m = new IntegerMatrix(2, 3, linearData);
        System.out.println(m);
    }
}

