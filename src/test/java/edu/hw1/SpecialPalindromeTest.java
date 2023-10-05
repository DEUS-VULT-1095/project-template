package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecialPalindromeTest {

    @Test
    void testIsPalindromeDescendant_whenProvidedPalindrome_returnsTrue() {
        // Arrange
        int number1 = 11211230;
        int number2 = 13001120;
        int number3 = 23336014;
        int number4 = 11;

        // Act
        boolean isPalindrome1 = SpecialPalindrome.isPalindromeDescendant(number1);
        boolean isPalindrome2 = SpecialPalindrome.isPalindromeDescendant(number2);
        boolean isPalindrome3 = SpecialPalindrome.isPalindromeDescendant(number3);
        boolean isPalindrome4 = SpecialPalindrome.isPalindromeDescendant(number4);

        // Assert
        assertTrue(isPalindrome1);
        assertTrue(isPalindrome2);
        assertTrue(isPalindrome3);
        assertTrue(isPalindrome4);
    }

    @Test
    void testPalindromeDescendant_whenProvidedNonPalindrome_returnsFalse() {
        // Arrange
        int number1 = 1488;
        int number2 = 975;
        int number3 = 223344;

        // Act
        boolean isPalindrome1 = SpecialPalindrome.isPalindromeDescendant(number1);
        boolean isPalindrome2 = SpecialPalindrome.isPalindromeDescendant(number2);
        boolean isPalindrome3 = SpecialPalindrome.isPalindromeDescendant(number3);

        // Assert
        assertFalse(isPalindrome1);
        assertFalse(isPalindrome2);
        assertFalse(isPalindrome3);
    }

    @Test
    void testPalindromeDescendant_whenProvidedNumberLessTwoDigits_returnsFalse() {
        // Arrange
        int number1 = 5;
        int number2 = 0;

        // Act
        boolean isPalindrome1 = SpecialPalindrome.isPalindromeDescendant(number1);
        boolean isPalindrome2 = SpecialPalindrome.isPalindromeDescendant(number2);

        // Assert
        assertFalse(isPalindrome1);
        assertFalse(isPalindrome2);
    }
}
