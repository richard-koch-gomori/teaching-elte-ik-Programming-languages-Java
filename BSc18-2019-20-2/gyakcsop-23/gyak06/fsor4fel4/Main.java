

class Main
{
    public static void main(String[] args)
    {
        int[] linearData = {1,2,3,4,5,6};

        /*
        int[] linearData = new int[6];
        linearData[0] = 1;
        linearData[0] = 2;
        ...
        */

        IntegerMatrix m = new IntegerMatrix(2, 3, linearData);
        System.out.println(m);
    }
}

