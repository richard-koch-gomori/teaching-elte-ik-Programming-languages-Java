

class IntegerMatrix
{
    private int rowNum, colNum;
    private int[][] data;

    public IntegerMatrix(int rowNum, int colNum, int[] linearData)
    {
        this.rowNum = rowNum;
        this.colNum = colNum;
        data = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; ++i)
        {
            for (int j = 0; j < colNum; ++j)
            {
                data[i][j] = linearData[i * colNum + j];
            }
        }
    }
}

class Main
{
    public static void main(String[] args)
    {
        int[] linearData = {1,2,3,4,5,6};
        IntegerMatrix m = new IntegerMatrix(2, 3, linearData);
    }
}


