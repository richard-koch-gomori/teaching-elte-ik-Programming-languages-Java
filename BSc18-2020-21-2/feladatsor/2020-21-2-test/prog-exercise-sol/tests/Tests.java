package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

import calc.Num;
import calc.Equation;
import calc.util.SheetException;
import calc.util.CellName;
import calc.Sheet;

public class Tests
{
    @Test
    public void CellName_test_isCellNameValid() // 1 pont
    {
        assertEquals(false, CellName.isCellNameValid(" A1"));
        assertEquals(false, CellName.isCellNameValid("a1"));
        assertEquals(false, CellName.isCellNameValid("A1.2"));
        assertEquals(true, CellName.isCellNameValid("A1"));
        assertEquals(true, CellName.isCellNameValid("A102"));
    }

    @Test
    public void CellName_test_getRowIndexFromCellName() throws SheetException // 0.5 pont
    {
        assertEquals(1, CellName.getRowIndexFromCellName("B1"));
        assertEquals(1024, CellName.getRowIndexFromCellName("B1024"));
    }

    // így is jó megoldás
    // fail() SimpleTest.java-ban benne van, de órai feladat nem volt ilyenre
    // SheetException kiengedése is teljesértékű megoldás
    @Test
    public void CellName_test_getColIndexFromCellName() // 0.5 pont
    {
        try
        {
            assertEquals(0, CellName.getColIndexFromCellName("A5"));
            assertEquals(3, CellName.getColIndexFromCellName("D1"));
        }
        catch (SheetException exc)
        {
            fail("Unexpected SheetException: " + exc);
        }
    }

    @Test
    public void Num_test_eval() throws SheetException // 0.5 pont
    {
        Num num = new Num(167);
        assertEquals(167, num.eval(null));
    }

    @Test(expected = IllegalArgumentException.class) // 0.5 pont
    public void Equation_test_ctor_space()
    {
        new Equation(" ");
    }

    @Test(expected = IllegalArgumentException.class) // 0.5 pont
    public void Equation_test_ctor_lowercase()
    {
        new Equation("a7 - 5");
    }

    @Test(expected = IllegalArgumentException.class) // 0.5 pont
    public void Equation_test_ctor_braces()
    {
        new Equation("F9 + 2*(2 - C9)");
    }

    @Test
    public void Sheet_test_toString_multiple_rows() throws SheetException
    {
        Sheet sheet = new Sheet(3, 2); // 3 sor 2 oszlop

        sheet.insertToSheet("A0", new Num(6)); // 0.5 pont
        sheet.insertToSheet("B0", new Num(5));

        sheet.insertToSheet("A1", new Num(2));
        sheet.insertToSheet("B1", new Num(6));

        sheet.insertToSheet("A2", new Num(2));
        sheet.insertToSheet("B2", new Num(9));

        // 0.5 pont
        String expected = "6 5" + System.lineSeparator() + "2 6" + System.lineSeparator() + "2 9";
        assertEquals(expected, sheet.toString());
    }

    @Test
    public void Equation_test_sum_cells() throws SheetException
    {
        Sheet sheet = new Sheet(3, 3); // 3 sor 3 oszlop

        sheet.insertToSheet("A0", new Num(6));
        sheet.insertToSheet("B0", new Num(5));

        sheet.insertToSheet("A1", new Num(2));
        sheet.insertToSheet("B1", new Num(6));

        sheet.insertToSheet("A2", new Num(2));
        sheet.insertToSheet("B2", new Num(9));

        for (int i = 0; i <= 2; ++i)
        {
            sheet.insertToSheet("C" + i, new Equation("A" + i + "+B" + i)); // 0.5 pont
        }

        // 0.5 pont
        String expected = "6 5 11" + System.lineSeparator() + "2 6 8" + System.lineSeparator() + "2 9 11";
        assertEquals(expected, sheet.toString());
    }

    @Test
    public void Equation_test_chaining_eq() throws SheetException
    {
        Sheet sheet = new Sheet(3, 4); // 3 sor 4 oszlop

        sheet.insertToSheet("A0", new Num(6));
        sheet.insertToSheet("B0", new Num(5));

        sheet.insertToSheet("A1", new Num(2));
        sheet.insertToSheet("B1", new Num(6));

        sheet.insertToSheet("A2", new Num(2));
        sheet.insertToSheet("B2", new Num(9));

        for (int i = 0; i <= 2; ++i)
        {
            sheet.insertToSheet("C" + i, new Equation("A" + i + "+B" + i));
            sheet.insertToSheet("D" + i, new Equation("C" + i + "/2")); // 0.5 pont
        }

        //System.out.println();
        //System.out.println(sheet);
        //System.out.println();

        // 0.5 pont
        String expected = "6 5 11 5" + System.lineSeparator() + "2 6 8 4" + System.lineSeparator() + "2 9 11 5";
        assertEquals(expected, sheet.toString());
    }

    @Test
    public void Equation_test_product_cell_with_integer() throws SheetException
    {
        Sheet sheet = new Sheet(3, 3); // 3 sor 3 oszlop

        sheet.insertToSheet("A0", new Num(6));
        sheet.insertToSheet("B0", new Num(5));

        sheet.insertToSheet("A1", new Num(2));
        sheet.insertToSheet("B1", new Num(6));

        sheet.insertToSheet("A2", new Num(2));
        sheet.insertToSheet("B2", new Num(9));

        for (int i = 0; i <= 2; ++i)
        {
            sheet.insertToSheet("C" + i, new Equation("" + 10 + "*B" + i)); // 0.5 pont
        }

        // 0.5 pont
        String expected = "6 5 50" + System.lineSeparator() + "2 6 60" + System.lineSeparator() + "2 9 90";
        assertEquals(expected, sheet.toString());
    }
}

