package edu.hw1;

// task2
public class Numbers {

    public static int countDigits(int number) {
        int numberOfDivisions = 0;
        do {
            numberOfDivisions++;
            number /= 10;
        } while (number != 0);

        return numberOfDivisions;
    }
}
