package edu.hw1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// task6
public class PermanentKaprekar {

    public static int countK(int number) {
        if (number > 999 && number < 9999) {
            String numberString = Integer.toString(number);
            for (int i = 1; i < numberString.length(); i++) {
                if (numberString.charAt(0) != numberString.charAt(i)) break;
                if (i == 3) throw new RuntimeException("Invalid provided number");
            }
            return countK(number, 0);
        }
        throw new RuntimeException("Invalid provided number");
    }

    private static int countK(int number, int callCount) {
        StringBuilder sb = new StringBuilder(Integer.toString(number));

        while (sb.length() != 4) {
            sb.insert(0, "0");
        }

        List<Integer> digitList = sb.toString()
            .chars()
            .map(Character::getNumericValue)
            .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        digitList.sort(Collections.reverseOrder());
        int bigNumber = 0;

        for (int digit : digitList) {
            bigNumber = bigNumber * 10 + digit;
        }

        Collections.sort(digitList);
        int smallNumber = 0;

        for (int digit : digitList) {
            smallNumber = smallNumber * 10 + digit;
        }

        int result = bigNumber - smallNumber;

        if (result == number) {
            return callCount;
        }

        callCount++;

        return countK(result, callCount);
    }

}
