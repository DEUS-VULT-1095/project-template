package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CyclicBitShiftTest {

    @ParameterizedTest
    @CsvSource({
        "8, 1, 4",
        "5, 2, 3",
        "0, 2, 0",
        "1, 0, 1"
    })
    void testRotateRight_WhenProvidedValidData_ReturnsNumber(int providedNumber, int shift, int expectedNumber) {
        // Arrange

        // Act
        int actualNumber = CyclicBitShift.rotateRight(providedNumber, shift);

        // Assert
        assertEquals(expectedNumber, actualNumber);
    }

    @ParameterizedTest
    @CsvSource({
        "-2, 1",
        "5, -2"
    })
    void testRotateRight_WhenProvidedInvalidData_ThrowRuntimeException(int providedNumber, int shift) {
        // Arrange
        String expectedErrorMessage = "Incorrect data provided for rotate";

        // Act & Assert
        RuntimeException actualException = assertThrows(RuntimeException.class,
            () -> CyclicBitShift.rotateRight(providedNumber, shift), "Should have thrown RuntimeException");

        // Assert
        assertEquals(expectedErrorMessage, actualException.getMessage(), "Incorrect exception message");
    }

    @ParameterizedTest
    @CsvSource({
        "16, 1, 1",
        "17, 2, 6",
        "0, 2, 0",
        "1, 0, 1"
    })
    void testRotateLeft_WhenProvidedValidData_ReturnsNumber(int providedNumber, int shift, int expectedNumber) {
        // Arrange

        // Act
        int actualNumber = CyclicBitShift.rotateLeft(providedNumber, shift);

        // Assert
        assertEquals(expectedNumber, actualNumber);
    }

    @ParameterizedTest
    @CsvSource({
        "-2, 1",
        "5, -2"
    })
    void testRotateLeft_WhenProvidedInvalidData_ThrowRuntimeException(int providedNumber, int shift) {
        // Arrange
        String expectedErrorMessage = "Incorrect data provided for rotate";

        // Act & Assert
        RuntimeException actualException = assertThrows(RuntimeException.class,
            () -> CyclicBitShift.rotateLeft(providedNumber, shift), "Should have thrown RuntimeException");

        // Assert
        assertEquals(expectedErrorMessage, actualException.getMessage(), "Incorrect exception message");
    }

    @ParameterizedTest
    @CsvSource({
        "8, 1, 4",
        "5, 2, 3",
        "0, 2, 0",
        "1, 0, 1"
    })
    void testRotateRightVersionTwo_WhenProvidedValidData_ReturnsNumber(int providedNumber, int shift, int expectedNumber) {
        // Arrange

        // Act
        int actualNumber = CyclicBitShift.rotateRightVersionTwo(providedNumber, shift);

        // Assert
        assertEquals(expectedNumber, actualNumber);
    }

    @ParameterizedTest
    @CsvSource({
        "-2, 1",
        "5, -2"
    })
    void testRotateRightVersionTwo_WhenProvidedInvalidData_ThrowRuntimeException(int providedNumber, int shift) {
        // Arrange
        String expectedErrorMessage = "Incorrect data provided for rotate";

        // Act & Assert
        RuntimeException actualException = assertThrows(RuntimeException.class,
            () -> CyclicBitShift.rotateRightVersionTwo(providedNumber, shift), "Should have thrown RuntimeException");

        // Assert
        assertEquals(expectedErrorMessage, actualException.getMessage(), "Incorrect exception message");
    }

    @ParameterizedTest
    @CsvSource({
        "16, 1, 1",
        "17, 2, 6",
        "0, 2, 0",
        "1, 0, 1"
    })
    void testRotateLeftVersionTwo_WhenProvidedValidData_ReturnsNumber(int providedNumber, int shift, int expectedNumber) {
        // Arrange

        // Act
        int actualNumber = CyclicBitShift.rotateLeftVersionTwo(providedNumber, shift);

        // Assert
        assertEquals(expectedNumber, actualNumber);
    }

    @ParameterizedTest
    @CsvSource({
        "-2, 1",
        "5, -2"
    })
    void testRotateLeftVersionTwo_WhenProvidedInvalidData_ThrowRuntimeException(int providedNumber, int shift) {
        // Arrange
        String expectedErrorMessage = "Incorrect data provided for rotate";

        // Act & Assert
        RuntimeException actualException = assertThrows(RuntimeException.class,
            () -> CyclicBitShift.rotateLeftVersionTwo(providedNumber, shift), "Should have thrown RuntimeException");

        // Assert
        assertEquals(expectedErrorMessage, actualException.getMessage(), "Incorrect exception message");
    }
}
