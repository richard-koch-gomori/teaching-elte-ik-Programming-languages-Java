

/*
{1, 2, 3, 4, 5, 6}

->


data = 
{1, 2, 3}
{4, 5, 6}


0..1
 0..2
  0, 1, 2, 3, 4, 5

linearData[0 * 3 + 0] == linearData[0]
linearData[0 * 3 + 1] == linearData[1]
linearData[0 * 3 + 2] == linearData[2]
linearData[1 * 3 + 0] == linearData[3]
linearData[1 * 3 + 1] == linearData[4]
linearData[1 * 3 + 2] == linearData[5]

*/

/*
int[] temp = {1, 2, 3}
for (int item : temp)
{
    // item == 1
    // item == 2
    // item == 3
}
*/

class IntegerMatrix
{
    private int[][] data;
    private int rowNum, colNum;

    public IntegerMatrix(int[] linearData, int rowNum, int colNum)
    {
        data = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; ++i) // i = 0 1
        {
            for (int j = 0; j < colNum; ++j) // j = 0 1 2
            {
                data[i][j] = linearData[i*colNum + j]; // 0 1 2; 3 4 5
            }
        }
        this.rowNum = rowNum;
        this.colNum = colNum;
    }

    // probléma ezzel a megoldással: a String módosíthatatlan tulajdonsága miatt a res egyes konkatenációjakor
    // minden alkalommal új String objektum jön létre a heap-en, ami borzasztóan pazarló
    /*
    public String toString() // "[1 2 3] sortörés [4 5 6]"
    {
        String res = "";
        for (int i = 0; i < rowNum; ++i) // i = 0 1
        {
            res += "[";
            for (int j = 0; j < colNum; ++j) // j = 0 1 2
            {
                res += data[i][j] + " ";
            }
            res += "]" + System.lineSeparator();
        }
        return res;
    }*/

    // a StringBuilder osztály hatékony sztring összeállítást tesz lehetővé
    /*
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rowNum; ++i) // i = 0 1
        {
            sb.append("[");
            for (int j = 0; j < colNum; ++j) // j = 0 1 2
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
            for (int item : row)
            {
                sb.append(item);
                sb.append(" ");
            }
            sb.append("]");
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

class Main
{
    public static void main(String[] args)
    {
        //int[][] matrix = new int[2][3];
        //matrix[1][2] = 6;
        // ...

        IntegerMatrix matrix = new IntegerMatrix(new int[]{1, 2, 3, 4, 5, 6}, 2, 3); // colNum - oszlop, rowNum - sor
        System.out.println(matrix);
    }
}

/*
// foreach ciklus
for (int e : arr)
{
    System.out.println(e);
}
*/
