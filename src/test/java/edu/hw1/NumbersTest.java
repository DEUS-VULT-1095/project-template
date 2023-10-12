package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @Test
    void testCountDigits_WhenIntInput_ReturnsDigitCount() {
        // Arrange
        int number1 = 4666;
        int number2 = 544;
        int number3 = 0;
        int number4 = -100500;

        // Act
        int digitCount1 = Numbers.countDigits(number1);
        int digitCount2 = Numbers.countDigits(number2);
        int digitCount3 = Numbers.countDigits(number3);
        int digitCount4 = Numbers.countDigits(number4);

        // Assert
        assertEquals(4, digitCount1);
        assertEquals(3, digitCount2);
        assertEquals(1, digitCount3);
        assertEquals(6, digitCount4);
    }
}
