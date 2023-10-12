package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// task6
public final class PermanentKaprekar {
    private final static int LOWER_BOUND = 999;
    private final static int UPPER_BOUND = 9999;
    private final static int LAST_INDEX = 3;
    private final static int MIN_NUMBER_DIGITS = 4;
    private final static int MULTIPLIER = 10;

    private PermanentKaprekar() {
    }

    public static int countK(int number) {
        if (number > LOWER_BOUND && number < UPPER_BOUND) {
            String numberString = Integer.toString(number);
            for (int i = 1; i < numberString.length(); i++) {
                if (numberString.charAt(0) != numberString.charAt(i)) {
                    break;
                }
                if (i == LAST_INDEX) {
                    throw new RuntimeException("All the numbers are the same");
                }
            }
            return countK(number, 0);
        }
        throw new RuntimeException("The boundaries of the incoming value are violated");
    }

    private static int countK(int number, int callCount) {
        StringBuilder sb = new StringBuilder(Integer.toString(number));

        while (sb.length() != MIN_NUMBER_DIGITS) {
            sb.insert(0, "0");
        }

        List<Integer> digitList = sb.toString()
            .chars()
            .map(Character::getNumericValue)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        digitList.sort(Collections.reverseOrder());
        int bigNumber = 0;

        for (int digit : digitList) {
            bigNumber = bigNumber * MULTIPLIER + digit;
        }

        Collections.sort(digitList);
        int smallNumber = 0;

        for (int digit : digitList) {
            smallNumber = smallNumber * MULTIPLIER + digit;
        }

        int result = bigNumber - smallNumber;

        if (result == number) {
            return callCount;
        }

        int newCallCount = callCount + 1;

        return countK(result, newCallCount);
    }

}
