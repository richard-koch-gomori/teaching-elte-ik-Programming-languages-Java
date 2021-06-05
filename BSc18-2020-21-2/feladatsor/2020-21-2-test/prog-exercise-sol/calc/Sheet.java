package calc;

import calc.util.CellName;
import calc.util.SheetException;

public class Sheet
{
    private Evaluable cells[][]; // 0.5 pont
    private int numOfRows, numOfCols;

    public Sheet(int numOfRows, int numOfCols)
    {
        if (numOfRows > CellName.colIndexes.length() || numOfRows <= 0 || numOfCols <= 0) // 0.5 pont
        {
            throw new IllegalArgumentException("The maximum numOfCols for a Sheet is: " + CellName.colIndexes.length());
        }

        this.numOfRows = numOfRows;
        this.numOfCols = numOfCols;
        this.cells = new Evaluable[numOfRows][numOfCols]; // 0.5 pont
    }

    // 1 pont
    public void insertToSheet(String cellName, Evaluable evaluable) throws SheetException
    {
        final int row = CellName.getRowIndexFromCellName(cellName);
        final int col = CellName.getColIndexFromCellName(cellName);
        if (row >= numOfRows || col >= numOfCols)
        {
            throw new IllegalArgumentException("Invalid cellName: " + cellName); // nem kérte explicit a feladat
        }
        cells[row][col] = evaluable;
    }

    // 0.5 pont
    public Evaluable getFromSheet(String cellName) throws SheetException
    {
        final int row = CellName.getRowIndexFromCellName(cellName);
        final int col = CellName.getColIndexFromCellName(cellName);
        if (row >= numOfRows || col >= numOfCols)
        {
            throw new IllegalArgumentException("Invalid cellName: " + cellName); // nem kérte explicit a feladat
        }
        return cells[row][col];
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(); // a feladat nem kötötte, ki, hogy nem szemetelhet, így most tekintsünk el attól, ha szemetel
        for (Evaluable[] row : cells) // 0.5 pont: bejárja a táblázatot
        {
            for (Evaluable cell : row)
            {
                try
                {
                    if (cell == null)
                    {
                        sb.append("null"); // 0.5 pont
                    }
                    else
                    {
                        sb.append(cell.eval(this)); // 1 pont
                    }
                }
                catch (Exception exc)
                {
                    // a feladat szövege nem rögzítette mit kell csinálni
                    sb.append(exc.getMessage());
                }
                sb.append(" ");
            }

            // 0.5 pont
            // nem volt tananyag, bármi más is elfogadható (pl. index szerinti bejárás és az utolsó elem külön kezelése)
            sb.deleteCharAt(sb.length() - 1);

            sb.append(System.lineSeparator());
        }

        // nem volt tananyag, bármi más is elfogadható (pl. index szerinti bejárás és az utolsó elem külön kezelése)
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}

