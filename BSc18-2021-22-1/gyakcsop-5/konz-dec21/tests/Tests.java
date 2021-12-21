package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import calc.util.*;
import calc.*;

public class Tests
{
    @Test
    public void test_isCellNameValid() throws SheetException
    {
        assertFalse(CellName.isCellNameValid("A 2"));
        assertFalse(CellName.isCellNameValid("a2"));
        assertFalse(CellName.isCellNameValid("AB"));
        assertTrue(CellName.isCellNameValid("A6"));
        assertTrue(CellName.isCellNameValid("A61"));
    }

    @Test
    public void test_getRowIndexFromCellName() throws SheetException
    {
        assertEquals(9, CellName.getRowIndexFromCellName("B9"));
        assertEquals(11, CellName.getRowIndexFromCellName("B11"));
    }

    @Test
    public void test_getColIndexFromCellName() throws SheetException
    {
        assertEquals(0, CellName.getColIndexFromCellName("A9"));
        assertEquals(1, CellName.getColIndexFromCellName("B11"));
    }

    @Test
    public void test_Num() throws SheetException
    {
        Num n = new Num(10);
        assertEquals(10, n.eval(null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Equation_whitespace()
    {
        new Equation("A0+ B0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Equation_lowcase()
    {
        new Equation("A0+b0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Equation_invalid_ch()
    {
        new Equation("A0+_B0");
    }

    @Test
    public void test_toString() throws SheetException
    {
        Sheet sheet = new Sheet(3, 2); // 3 sor 2 oszlop

        sheet.insertToSheet("A0", new Num(6));
        sheet.insertToSheet("B0", new Num(5));

        sheet.insertToSheet("A1", new Num(2));
        sheet.insertToSheet("B1", new Num(6));

        sheet.insertToSheet("A2", new Num(2));
        sheet.insertToSheet("B2", new Num(9));

        String expected = "6 5" + System.lineSeparator() + "2 6" + System.lineSeparator() + "2 9";
        assertEquals(expected, sheet.toString());
    }

    @Test
    public void test_toString_sum() throws SheetException
    {
        Sheet sheet = new Sheet(3, 3); // 3 sor 2 oszlop

        sheet.insertToSheet("A0", new Num(6));
        sheet.insertToSheet("B0", new Num(5));

        sheet.insertToSheet("A1", new Num(2));
        sheet.insertToSheet("B1", new Num(6));

        sheet.insertToSheet("A2", new Num(2));
        sheet.insertToSheet("B2", new Num(9));

        for (int i = 0; i < 3; ++i)
        {
            sheet.insertToSheet("C"+i, new Equation("A"+i+"+B"+i));
        }

        String expected = "6 5 11" + System.lineSeparator() + "2 6 8" + System.lineSeparator() + "2 9 11";
        System.out.println(sheet.toString());
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
            sheet.insertToSheet("D" + i, new Equation("C" + i + "/2"));
        }

        //System.out.println();
        //System.out.println(sheet);
        //System.out.println();

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
