package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @DisplayName("Test convert to roman. Provided valid data.")
    @ParameterizedTest
    @CsvSource({
        "1, I",
        "2458, MMCDLVIII",
        "1488, MCDLXXXVIII",
        "3999, MMMCMXCIX"
    })
    void testConvertToRoman_whenProvidedValidData_returnsRomanNumber(int providedArabianNumber, String expectedRomanNumber) {
        // Arrange

        // Act
        String actualRomanNumber = Task4.convertToRoman(providedArabianNumber);

        // Assert
        assertEquals(expectedRomanNumber, actualRomanNumber, "Expected roman number not correct");
    }

    @DisplayName("Test convert to roman. Provided not valid data.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 4000})
    void testConvertToRoman_whenProvidedInvalidData_throwsRuntimeException(int providedArabianNumber) {
        // Arrange
        String expectedExceptionMessage = "Roman number can't be bigger 3999 and lower 1 value";

        // Act & Assert
        RuntimeException actualException = assertThrows(RuntimeException.class,
            () -> Task4.convertToRoman(providedArabianNumber), "Should be thrown Runtime Exception");

        // Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Incorrect exception message");
    }
}
