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
}

