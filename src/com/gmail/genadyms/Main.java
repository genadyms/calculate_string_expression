package com.gmail.genadyms;

public class Main {

    public static void main(String[] args) throws UnsupportedCharacterException {
        String s = "5 * 4 + 12 + 34 + 5 * 9 + 4+1+9 ";
        StringCalculation stringCalculation = new StringCalculation(s);
        System.out.println(stringCalculation.calculate());
    }
}
