package calc.util;

public class CellName
{
    static final String colIndexes = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static boolean isCellNameValid(String cellName)
    {
        if (colIndexes.indexOf(cellName.charAt(0)) == -1)
        {
            return false;
        }
        for (int i = 1; i < cellName.length(); ++i)
        {
            if (!Character.isDigit(cellName.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

    public static int getRowIndexFromCellName(String cellName) throws SheetException
    {
        if (!isCellNameValid(cellName))
        {
            throw new SheetException(cellName + " is not valid");
        }
        int rowIdx = Integer.parseInt(cellName.substring(1));
        return rowIdx;
    }

    public static int getColIndexFromCellName(String cellName) throws SheetException
    {
        return colIndexes.indexOf(cellName.charAt(0));
    }
}
