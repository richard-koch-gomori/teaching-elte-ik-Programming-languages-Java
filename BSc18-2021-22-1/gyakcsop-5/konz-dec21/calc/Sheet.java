package calc;

import calc.util.*;

public class Sheet
{
    Evaluable[][] data;

    public Sheet(int numOfRows, int numOfCols)
    {
        if (numOfCols > CellName.colIndexes.length() || numOfRows < 0 || numOfCols < 0)
        {
            throw new IllegalArgumentException("invalid Sheet");
        }
        data = new Evaluable[numOfRows][numOfCols];
    }
}