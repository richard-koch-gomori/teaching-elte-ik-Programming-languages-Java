

class IntegerMatrix
{
    private int rowNum, colNum;
    private int[][] data;

    public IntegerMatrix(int rowNum, int colNum, int[] linearData)
    {
        data = new int[rowNum][colNum];
        // data[0..rowNum-1][0..colNum-1]
        this.rowNum = rowNum;
        this.colNum = colNum;
        
        for (int i = 0; i < rowNum; i++)
        {
            for (int j = 0; j < colNum; ++j)
            {
                data[i][j] = linearData[i * colNum + j];

/*
pl.
rowNum = 2
colNum = 2
linearData = {5, 3, 2, 1}

i = 0..1
 j = 0..1
  data[i][j] = linearData[i * 2 + j] // 0; 1; 2; 3; ...

data[0][0] = 5;
data[0][1] = 3;
data[1][0] = 2;
data[1][1] = 1;
*/            
            }
        }
    }

    // probléma ezzel a megoldással: a String módosíthatatlan tulajdonsága miatt a res egyes konkatenációjakor
    // minden alkalommal új String objektum jön létre a heap-en, ami borzasztóan pazarló
/*
    public String toString()
    {
        String result = "";
        for (int i = 0; i < rowNum; i++)
        {
            for (int j = 0; j < colNum; ++j)
            {
                result += data[i][j] + ",";
            }
            result += System.lineSeparator();
        }
        return result;
    }
*/

    // a StringBuilder osztály hatékony sztring összeállítást tesz lehetővé
/*
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rowNum; i++)
        {
            for (int j = 0; j < colNum; ++j)
            {
                sb.append(data[i][j]);
                sb.append(",");
            }
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
            for (int item : row)
            {
                sb.append(item);
                sb.append(",");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}

class Main
{
    public static void main(String[] args)
    {
        /*
        int[] array = new int[4];
        array[0] = 5;
        array[1] = 3;
        array[2] = 2;
        array[3] = 1;
        */

        IntegerMatrix im = new IntegerMatrix(2, 2, new int[]{5, 3, 2, 1});
        /*
        5 3
        2 1
        */
        System.out.println(im);

        String a = "alma";
        a += "korte";
    }
}

/*
int[]{1, 2, 3}

for (int i = 0; i < 3; ++i)
{
    array[i]
}

for (int item : array)
{
    System.out.println(item);
}
*/
