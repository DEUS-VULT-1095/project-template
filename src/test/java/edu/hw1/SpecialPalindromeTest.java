package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SpecialPalindromeTest {

    @ParameterizedTest
    @ValueSource(ints = {11211230, 13001120, 23336014, 11})
    void testIsPalindromeDescendant_WhenProvidedPalindrome_ReturnsTrue(int providedNumber) {
        // Arrange

        // Act
        boolean isPalindrome = SpecialPalindrome.isPalindromeDescendant(providedNumber);

        // Assert
        assertTrue(isPalindrome);
    }

    @ParameterizedTest
    @ValueSource(ints = {1488, 975, 223344})
    void testPalindromeDescendant_WhenProvidedNonPalindrome_ReturnsFalse(int providedNumber) {
        // Arrange

        // Act
        boolean isPalindrome = SpecialPalindrome.isPalindromeDescendant(providedNumber);

        // Assert
        assertFalse(isPalindrome);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 0})
    void testPalindromeDescendant_WhenProvidedNumberLessTwoDigits_ReturnsFalse(int providedNumber) {
        // Arrange

        // Act
        boolean isPalindrome = SpecialPalindrome.isPalindromeDescendant(providedNumber);

        // Assert
        assertFalse(isPalindrome);
    }
}
