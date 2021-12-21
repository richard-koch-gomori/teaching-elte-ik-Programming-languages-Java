package calc;

import calc.util.*;

public class Sheet
{
    private Evaluable[][] data;
    private int numOfRows, numOfCols;

    public Sheet(int numOfRows, int numOfCols)
    {
        if (numOfCols > CellName.colIndexes.length() || numOfRows < 0 || numOfCols < 0)
        {
            throw new IllegalArgumentException("invalid Sheet");
        }
        this.numOfRows = numOfRows;
        this.numOfCols = numOfCols;
        data = new Evaluable[numOfRows][numOfCols];
    }

    public void insertToSheet(String cellName, Evaluable evaluable) throws SheetException
    {
        int row = CellName.getRowIndexFromCellName(cellName);
        int col = CellName.getColIndexFromCellName(cellName);
        if (row > numOfRows || col > numOfCols)
        {
            throw new SheetException("out of index");
        }
        data[row][col] = evaluable;
    }

    public Evaluable getFromSheet(String cellName) throws SheetException
    {
        int row = CellName.getRowIndexFromCellName(cellName);
        int col = CellName.getColIndexFromCellName(cellName);
        if (row > numOfRows || col > numOfCols)
        {
            throw new SheetException("out of index");
        }
        return data[row][col];
    }

    public static int constructIntFromOperandStr(String oprandStr, Sheet sheet) throws SheetException
    {
        // cellanév
        if (Character.isUpperCase(oprandStr.charAt(0)))
        {
            return sheet.getFromSheet(oprandStr).eval(sheet);
        }

        // szám
        else
        {
            return Integer.parseInt(oprandStr);
        }
    }

    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        try
        {
            for (int i = 0; i < numOfRows; ++i)
            {
                for (int j = 0; j < numOfCols; ++j)
                {
                    int x = data[i][j].eval(this);
                    res.append(x);
                    if (j < numOfCols - 1)
                    {
                        res.append(" ");
                    }
                }
                if (i < numOfRows - 1)
                {
                    res.append(System.lineSeparator());
                }
            }
        }
        catch (Exception exc)
        {
            return "";
        }
        return res.toString();
    }
}