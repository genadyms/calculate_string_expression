package com.gmail.genadyms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CharacterValidator {
    private final Set<Character> digits;

    public CharacterValidator(List<Character> allowedChars) {
        this.digits = new HashSet<>(allowedChars);
    }

    public void validateChar(char ch) throws UnsupportedCharacterException {
        if (!this.digits.contains(ch)) {
            throw new UnsupportedCharacterException(ch + " is not number");
        }
    }

}
