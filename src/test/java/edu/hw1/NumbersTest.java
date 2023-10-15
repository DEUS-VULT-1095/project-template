package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @ParameterizedTest
    @CsvSource({
        "4666, 4",
        "544, 3",
        "0, 1",
        "-100500, 6"
    })
    void testCountDigits_WhenIntInput_ReturnsDigitCount(int providedNumber, int expectedDigitCount) {
        // Arrange

        // Act
        int actualDigitCount = Numbers.countDigits(providedNumber);

        // Assert
        assertEquals(expectedDigitCount, actualDigitCount);
    }
}
