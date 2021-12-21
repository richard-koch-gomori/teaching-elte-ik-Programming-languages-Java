package calc;

import calc.util.*;

public class Equation implements Evaluable
{
    private String operand1, operand2;
    private Character operator;
    
    public Equation(String eqstr)
    {
        for (int i = 0; i < eqstr.length(); ++i)
        {
            char ch = eqstr.charAt(i);
            if (!(Character.isUpperCase(ch) || Character.isDigit(ch) || ch == '+' || ch == '-' || ch == '*' || ch == '/'))
            {
                throw new IllegalArgumentException("invalid char in eqstr");
            }

            if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                operator = ch;
                operand1 = eqstr.substring(0, i);
                operand2 = eqstr.substring(i+1, eqstr.length());
            }
        }
    }

    @Override
    public int eval(Sheet sheet) throws SheetException
    {
        int operand1_int = Sheet.constructIntFromOperandStr(operand1, sheet);
        int operand2_int = Sheet.constructIntFromOperandStr(operand2, sheet);

        switch (operator)
        {
            case '+':
            {
                return operand1_int + operand2_int;
            }
            case '-':
            {
                if (operand1_int - operand2_int < 0)
                {
                    throw new ArithmeticException("sub error");
                }
                return operand1_int - operand2_int;
            }
            case '*':
            {
                return operand1_int * operand2_int;
            }
            case '/':
            {
                if (operand2_int == 0)
                {
                    throw new ArithmeticException("div error");
                }
                return operand1_int / operand2_int;
            }
        }
        return 0;
    }
}

/*
Ci=Ai+Bi
pl. C0=A0+B0
+ operátor (műveleti jel)
A0 operandus (szám vagy cellanév)
A0+
*/

