package calc;

import calc.util.*;

public interface Evaluable
{
    int eval(Sheet sheet) throws SheetException;
}

