package calc;

import calc.util.*;

public class Num implements Evaluable
{
    private int num;

    public Num(int num)
    {
        if (num < 0)
        {
            throw new IllegalArgumentException("num is neg.");
        }
        this.num = num;
    }

    @Override
    public int eval(Sheet sheet) throws SheetException
    {
        return num;
    }
}

