package edu.hw1;

// task2
public final class Numbers {
    private static final int DIVIDER = 10;

    private Numbers() {
    }

    public static int countDigits(int number) {
        int testingNumber = number;
        int numberOfDigits = 0;

        do {
            numberOfDigits++;
            testingNumber /= DIVIDER;
        } while (testingNumber != 0);

        return numberOfDigits;
    }
}
