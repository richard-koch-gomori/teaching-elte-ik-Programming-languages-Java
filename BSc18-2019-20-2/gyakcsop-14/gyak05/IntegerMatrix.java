

public class IntegerMatrix
{
    private int[][] data;
    private int rowNum, colNum;

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

    public String toString()
    {
/*
        String s = "";
        for (int i = 0; i < rowNum; ++i)
        {
            s += "[";
            for (int j = 0; j < colNum; ++j)
            {
                s += data[i][j] + " ";
            }
            s += "]";
            s += System.lineSeparator();
        }
*/

/*
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rowNum; ++i)
        {
            sb.append("[");
            for (int j = 0; j < colNum; ++j)
            {
                sb.append(data[i][j]);
                sb.append(" ");
            }
            sb.append("]");
            sb.append(System.lineSeparator());
        }
        return sb.toString();
*/

        StringBuilder sb = new StringBuilder();
        for (int[] row : data)
        {
            sb.append("[");
            for (int e : row)
            {
                sb.append(e);
                sb.append(" ");
            }
            sb.append("]");
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

/*
data = 
[ 0 0 1 ]
[ 2 3 4 ]
*/


