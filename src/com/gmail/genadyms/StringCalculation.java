package com.gmail.genadyms;

import java.util.Arrays;

public class StringCalculation {
    private final static char MULTIPLY_CHAR = '*';
    private final static char SPACE_CHAR = ' ';
    private final static char PLUS_CHAR = '+';
    private final static Character[] allowedCharArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private final CharacterValidator validator;
    private final String srcString;

    public StringCalculation(String srcString) {
        this.validator = new CharacterValidator(Arrays.asList(allowedCharArray));
        this.srcString = srcString;
    }

    public long calculate() throws UnsupportedCharacterException {
        ExpressionItem expressionItem = new ExpressionItem();
        long result = 0;
        for (int i = 0; i < srcString.length(); i++) {
            char currentChar = srcString.charAt(i);
            if (currentChar == PLUS_CHAR) {
                result += expressionItem.getValue();
                expressionItem = new ExpressionItem();
            } else if (currentChar == SPACE_CHAR) {
                continue;
            } else if (currentChar == MULTIPLY_CHAR) {
                expressionItem.changeOperand();
            } else {
                validator.validateChar(currentChar);
                expressionItem.add(currentChar);
            }
        }
        result += expressionItem.getValue();
        return result;
    }

}
