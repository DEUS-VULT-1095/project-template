package edu.hw3;

import java.util.List;

public final class Task4 {
    private static final List<String> ROMAN_NUMBERS =
        List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
    private static final List<Integer> ARABIAN_NUMBERS =
        List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
    private static final int MAX_ROMAN_NUMBER = 3999;
    private static final int MIN_ROMAN_NUMBER = 1;

    private Task4() {
    }

    public static String convertToRoman(int inputArabianNumber) {
        int arabianNumber = inputArabianNumber;

        if (arabianNumber > MAX_ROMAN_NUMBER || arabianNumber < MIN_ROMAN_NUMBER) {
            throw new RuntimeException("Roman number can't be bigger 3999 and lower 1 value");
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ARABIAN_NUMBERS.size(); i++) {
            while (arabianNumber >= ARABIAN_NUMBERS.get(i)) {
                sb.append(ROMAN_NUMBERS.get(i));
                arabianNumber -= ARABIAN_NUMBERS.get(i);
            }
        }

        return sb.toString();
    }
}
