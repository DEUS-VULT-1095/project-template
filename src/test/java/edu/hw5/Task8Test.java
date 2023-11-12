package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Task8Test {

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "111", "000", "10101", "00111"})
    void testIsValid1_whenProvidedValidValue_returnsTrue(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task8.isValid1(inputString);

        // Assert
        assertTrue(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"01", "00", "1111", "0001", "110101", "010111"})
    void testIsValid1_whenProvidedInvalidValue_returnsFalse(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task8.isValid1(inputString);

        // Assert
        assertFalse(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10", "1110", "001", "101011", "00111"})
    void testIsValid2_whenProvidedValidValue_returnsTrue(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task8.isValid2(inputString);

        // Assert
        assertTrue(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"01", "101", "11100", "0010", "1010110", "001111"})
    void testIsValid2_whenProvidedInvalidValue_returnsFalse(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task8.isValid2(inputString);

        // Assert
        assertFalse(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"000", "101010101000101110", "101010111000000", "0010", "0100010110", "000111"})
    void testIsValid3_whenProvidedValidValue_returnsTrue(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task8.isValid3(inputString);

        // Assert
        assertTrue(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0000", "1010101010001011010", "1010010111000000", "00010", "01000010110", "0001101"})
    void testIsValid3_whenProvidedInvalidValue_returnsFalse(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task8.isValid3(inputString);

        // Assert
        assertFalse(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111", "0101", "110", "1"})
    void testIsValid4_whenProvidedValidValue_returnsTrue(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task8.isValid4(inputString);

        // Assert
        assertTrue(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "11"})
    void testIsValid4_whenProvidedInvalidValue_returnsFalse(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task8.isValid4(inputString);

        // Assert
        assertFalse(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1111", "10111", "101010101", "1"})
    void testIsValid5_whenProvidedValidValue_returnsTrue(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task8.isValid5(inputString);

        // Assert
        assertTrue(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1101", "00111", "101000101", "0"})
    void testIsValid5_whenProvidedInvalidValue_returnsFalse(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task8.isValid5(inputString);

        // Assert
        assertFalse(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"001", "100", "01000", "00100"})
    void testIsValid6_whenProvidedValidValue_returnsTrue(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task8.isValid6(inputString);

        // Assert
        assertTrue(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0011", "10", "110", "0000111", "11"})
    void testIsValid6_whenProvidedInvalidValue_returnsFalse(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task8.isValid6(inputString);

        // Assert
        assertFalse(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001", "100", "010100", "10101001", "1"})
    void testIsValid7_whenProvidedValidValue_returnsTrue(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task8.isValid7(inputString);

        // Assert
        assertTrue(actualResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10011", "10110", "010100111", "1101011001"})
    void testIsValid7_whenProvidedInvalidValue_returnsFalse(String inputString) {
        // Arrange

        // Act
        boolean actualResult = Task8.isValid7(inputString);

        // Assert
        assertFalse(actualResult);
    }
}
