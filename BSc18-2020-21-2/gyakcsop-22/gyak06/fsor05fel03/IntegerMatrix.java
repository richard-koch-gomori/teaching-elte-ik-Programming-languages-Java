/**
 * @author author_name
 * @since 2.0
 * @version 2.0
 */

public class IntegerMatrix {
    private int rowNum;
    private int colNum;
    private int[][] data;

    /**
     * <p>Store the given 1D array as a matrix.</p>
     * @param rowNum number of rows
     * @param colNum number of coloumns
     * @param linearData integers stored in 1D array
     * @since 1.0
     */
    public IntegerMatrix(int rowNum, int colNum, int[] linearData){
        if(rowNum*colNum != linearData.length)
            throw new IllegalArgumentException("rowNum*colNum != linearData.length");

        this.rowNum = rowNum;
        this.colNum = colNum;
        data = new int[rowNum][colNum];

        for(int i = 0; i < linearData.length; i++) {
            int row = (int) Math.floor(i / colNum);
            int col = i % colNum;
            System.out.println(i + " " + row + " " +col );
            data[row][col] = linearData[i];
        }
    }

    public String toString(){
        return toString3();
    }

    /**
     * <p>Converts the matrix elements to string with proper formatting,
     * initial version.</p>
     * @return the matrix items converted to String
     * @since 1.0
     */
    public String toString1(){
        
        String s = "";

        if(data.length < 1) return s;

        s += data[0].length < 1 ? "" : data[0][0]; 

        for(int j=1; j<data[0].length; j++){
            s += "," + data[0][j]; 
        }

        for(int i=1; i<data.length; i++){
            s += ";";

            s += data[i].length < 1 ? "" : data[i][0]; 
            for(int j=1; j<data[i].length; j++){
                s += "," + data[i][j]; 
            }
        }

        return s;
    }

    /**
     * <p>Converts the matrix elements to string with proper formatting,
     * initial version.</p>
     * @return the matrix items converted to String
     * @since 1.0
     */
    public String toString2(){
        String s = "";
        String rowDelim = "";
        String colDelim = "";

        for(int[] row : data){
            s += rowDelim;
            rowDelim = ";";
            for(int elem :row){
                s += colDelim;
                colDelim = ",";
                s += elem;
            }
            colDelim = "";
        }
        return s;
    }

    /**
     * <p>Converts the matrix elements to string with proper formatting,
     * uses StringBuilder for better performance.</p>
     * @return the matrix items converted to String
     * @since 2.0
     */
    public String toString3(){
        StringBuilder sb = new StringBuilder();
        String rowDelim = "";
        String colDelim = "";

        for(int[] row : data){
            sb.append(rowDelim);
            rowDelim = ";";
            for(int elem : row){
                sb.append(colDelim);
                colDelim = ",";
                sb.append(elem);
            }
            colDelim = "";
        }

        return sb.toString();
    }
}
