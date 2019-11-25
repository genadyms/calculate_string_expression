package com.gmail.genadyms;

import java.util.LinkedList;
import java.util.List;

public class ExpressionItem {
    private final List<StringBuilder> operands;
    private StringBuilder currentOperand;

    ExpressionItem() {
        operands = new LinkedList<>();
        currentOperand = new StringBuilder();
        operands.add(currentOperand);
    }

    public void changeOperand() {
        currentOperand = new StringBuilder();
        operands.add(currentOperand);
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

}
