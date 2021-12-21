package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

import calc.util.*;

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
}

