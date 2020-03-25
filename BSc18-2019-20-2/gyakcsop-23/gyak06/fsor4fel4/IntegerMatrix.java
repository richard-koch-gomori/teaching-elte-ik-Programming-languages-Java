

/*
data = 
[1 2 3]
[4 5 6]

data[1][2] == 6


indexek:      0 1 2 3 4 5
linearData = {1,2,3,4,5,6}


rowNum = 2
colNum = 3

i = 0..1
 j = 0..2
  data[i][j] = linearData[i * 3 + j]


linearData[0 * 3 + 0] == linearData[0]
linearData[0 * 3 + 1] == linearData[1]
linearData[0 * 3 + 2] == linearData[2]

linearData[1 * 3 + 0] == linearData[3]
linearData[1 * 3 + 1] == linearData[4]
linearData[1 * 3 + 2] == linearData[5]
*/

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

/*
    // probléma ezzel a megoldással: a String módosíthatatlan tulajdonsága miatt a res egyes konkatenációjakor
    // minden alkalommal új String objektum jön létre a heap-en, ami borzasztóan pazarló
    public String toString()
    {
        String res = "";
        for (int i = 0; i < rowNum; ++i)
        {
            res += "[";
            for (int j = 0; j < colNum; ++j)
            {
                res += data[i][j] + " ";
            }
            res += "]";
            res += System.lineSeparator();
        }
        return res;
    }
*/

/*
    // a StringBuilder osztály hatékony sztring összeállítást tesz lehetővé
    public String toString()
    {
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
    }
*/

    public String toString()
    {
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
stack           heap

sb             "[1 2 3 ] . . . "
*/





/*
int[] arr = {1, 3, 5, 6};

for (int i = 0; i < 4; ++i)
{
    System.out.println(arr[i])
}




// foreach ciklus
for (int e : arr)
{
    System.out.println(e);
}
*/


