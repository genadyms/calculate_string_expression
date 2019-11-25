package com.gmail.genadyms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CalculateStringExpression {
    private final static char MULTIPLY_CHAR = '*';
    private final static char PLUS_CHAR = '+';

    private final CharacterValidator validator;
    private final Set<Character> excludedChars;

    public CalculateStringExpression(Character[] digits, Character[] excludedChars) {
        this.validator = new CharacterValidator(Arrays.asList(digits));
        this.excludedChars = new HashSet<>(Arrays.asList(excludedChars));
    }

    public long calculate(String srcString) throws UnsupportedCharacterException {
        ExpressionItem expressionItem = new ExpressionItem();
        long result = 0;
        for (int i = 0; i < srcString.length(); i++) {
            char currentChar = srcString.charAt(i);
            if (currentChar == PLUS_CHAR) {
                result += expressionItem.getValue();
                expressionItem = new ExpressionItem();
            } else if (this.excludedChars.contains(currentChar)) {
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
