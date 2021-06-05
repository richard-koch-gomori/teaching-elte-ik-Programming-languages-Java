package calc.util;

public class CellName
{
    // 0.5 pont
    public static final String colIndexes = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static boolean isCellNameValid(String cellName)
    {
        if (!colIndexes.contains("" + cellName.charAt(0))) // 0.5 pont
        {
            return false;
        }
        for (int i = 1; i < cellName.length(); ++i)
        {
            if (!Character.isDigit(cellName.charAt(i))) // 0.5 pont
            {
                return false;
            }
        }
        return true; // 0.5 pont: felismeri h megfelelő
    }

    // 0.5 pont: throws SheetException

    public static int getRowIndexFromCellName(String cellName) throws SheetException
    {
        if (!isCellNameValid(cellName))
        {
            throw new SheetException("Invalid cellName: " + cellName); // 0.5 pont
        }

        String rowStr = cellName.substring(1, cellName.length()); // 0.5 pont
        return Integer.parseInt(rowStr);
    }

    public static int getColIndexFromCellName(String cellName) throws SheetException
    {
        if (!isCellNameValid(cellName))
        {
            throw new SheetException("Invalid cellName: " + cellName); // 0.5 pont
        }

        Character colChar = cellName.charAt(0); // 0.5 pont
        return colIndexes.indexOf(colChar); // 0.5 pont
    }
}

