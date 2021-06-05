package calc;

import calc.util.SheetException;

public class Num implements Evaluable // 0.5 pont
{
    private int number;

    public Num(int number) // 0.5 pont
    {
        if (number < 0)
        {
            throw new IllegalArgumentException("Negative numbers are not supported yet."); // 0.5 pont
        }
        this.number = number;
    }

    @Override
    public int eval(Sheet sheet) throws SheetException
    {
        return number; // 0.5 pont
    }
}

