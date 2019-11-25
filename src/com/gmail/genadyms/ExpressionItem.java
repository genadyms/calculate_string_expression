package com.gmail.genadyms;

import java.util.LinkedList;
import java.util.List;

public class ExpressionItem {
    private final List<StringBuilder> operands;
    private StringBuilder currentOperand;

    public ExpressionItem() {
        operands = new LinkedList<>();
        updateOperands();
    }

    public void changeOperand() {
        updateOperands();
    }

    public void add(char ch) {
        currentOperand.append(ch);
    }

    public long getValue() throws UnsupportedCharacterException {
        long result = 1;
        for (StringBuilder sb : operands) {
            if (sb.length() == 0) {
                throw new UnsupportedCharacterException("Incorrect expression");
            }
            result *= Long.valueOf(sb.toString());
        }
        return result;
    }

    private void updateOperands() {
        currentOperand = new StringBuilder();
        operands.add(currentOperand);
    }

}
