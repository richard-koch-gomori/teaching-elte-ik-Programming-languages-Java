package calc;

import calc.util.CellName;
import calc.util.SheetException;

public class Equation implements Evaluable // 0.5 pont
{
    private String operand1, operand2; // 0.5 pont
    private Character operator;

    public Equation(String eq)
    {
        for (int i = 0; i < eq.length(); ++i)
        {
            if (!(Character.isUpperCase(eq.charAt(i)) || Character.isDigit(eq.charAt(i)) || // 0.5 pont
                eq.charAt(i) == '+' || eq.charAt(i) == '-' || eq.charAt(i) == '*' || eq.charAt(i) == '/'))
            {
                throw new IllegalArgumentException("Invalid character in equation: " + eq.charAt(i)); // 0.5 pont
            }

            if (eq.charAt(i) == '+' || eq.charAt(i) == '-' || eq.charAt(i) == '*' || eq.charAt(i) == '/')
            {
                if (this.operator != null)
                {
                    throw new IllegalArgumentException("Multiple operators are found in equation: " + eq); // ezt nem kérte a feladat
                }
                this.operator = eq.charAt(i); // 0.5 pont
            }
        }

        /*
        0123456
        5-D7
        operatorIdx=1
        eq.length()=4
        */
        final int operatorIdx = eq.indexOf("" + this.operator);
        if (operator == null)
        {
            throw new IllegalArgumentException("No operator found in equation: " + eq);
        }
        // split() is jó megoldás
        operand1 = eq.substring(0, operatorIdx); // 0.5 pont
        operand2 = eq.substring(operatorIdx + 1, eq.length()); // 0.5 pont
        if (operand1.length() == 0 || operand2.length() == 0) // ezt nem kérte a feladat
        {
            throw new IllegalArgumentException("Invalid equation: " + eq);
        }
    }

    private static int constructIntFromOperandStr(String operandStr, Sheet sheet) throws SheetException
    {
        if (CellName.colIndexes.contains("" + operandStr.charAt(0))) // 0.5 pont
        {
            int num = sheet.getFromSheet(operandStr).eval(sheet); // 1 pont
            return num;
        }
        else
        {
            return Integer.parseInt(operandStr); // 0.5 pont
        }
    }

    @Override
    public int eval(Sheet sheet) throws SheetException
    {
        // 0.5 pont
        int int1 = constructIntFromOperandStr(this.operand1, sheet);
        int int2 = constructIntFromOperandStr(this.operand2, sheet);

        switch (operator)
        {
            case '+': return int1 + int2;
            case '-':
            {
                if (int1 - int2 < 0) // 0.5 pont
                {
                    throw new ArithmeticException("Negative numbers are not supported yet.");
                }
                return int1 - int2;
            }
            case '*': return int1 * int2;
            case '/':
            {
                if (int2 == 0) // 0.5 pont
                {
                    throw new ArithmeticException("Division by zero from equation: " + operand1 + operator + operand2);
                }
                return int1 / int2;
            }
            default: throw new IllegalStateException("Illegal operator in equation: " + operator); // nem kérte a feladat
        }
    }
}

