package com.gmail.genadyms;

public class Main {

    public static void main(String[] args) throws UnsupportedCharacterException {
        String originString = "5 * 4 + 12 + 34 + 5 * 9 + 4+1+9 ";
        Character[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char spaceChar = ' ';
        CalculateStringExpression stringCalculation = new CalculateStringExpression(digits, new Character[]{spaceChar});
        System.out.println(stringCalculation.calculate(originString));
    }
}
