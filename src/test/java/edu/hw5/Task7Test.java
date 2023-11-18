package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task7Test {

    @ParameterizedTest
    @ValueSource(strings = {"1100010", "000", "010111000", "1100000000"})
    void testIsValid1_whenProvidedValidString_returnsTrue(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task7.isValid1(inputString);

        // Assert
        assertTrue(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"000w", "031", "001"})
    void testIsValid1_whenProvidedInvalidString_returnsFalse(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task7.isValid1(inputString);

        // Assert
        assertFalse(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"11", "0111110", "1010100101"})
    void testIsValid2_whenProvidedValidString_returnsTrue(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task7.isValid2(inputString);

        // Assert
        assertTrue(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"010101", "10w1"})
    void testIsValid2_whenProvidedInvalidString_returnsFalse(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task7.isValid2(inputString);

        // Assert
        assertFalse(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "01", "011"})
    void testIsValid3_whenProvidedValidString_returnsTrue(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task7.isValid3(inputString);

        // Assert
        assertTrue(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "01010", "1234"})
    void testIsValid3_whenProvidedInvalidString_returnsFalse(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task7.isValid3(inputString);

        // Assert
        assertFalse(actualResult);
    }
}
