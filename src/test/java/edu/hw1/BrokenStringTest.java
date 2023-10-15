package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BrokenStringTest {

    @ParameterizedTest
    @CsvSource(value = {
        "123456, 214365",
        "hTsii  s aimex dpus rtni.g, This is a mixed up string."
    })
    void testFixString_WhenBrokenStringInput_ReturnsFixedString(String brokenString, String expectedString) {
        // Arrange

        // Act
        String actualString = BrokenString.fixString(brokenString);

        // Assert
        assertEquals(expectedString, actualString);
    }

    @ParameterizedTest
    @CsvSource({
        "badce, abcde",
        "w, w"
    })
    void testFixString_WhenProvidedStringWithOddNumberOfCharacters_ReturnsFixedString(String brokenString, String expectedString) {
        // Arrange

        // Act
        String actualString = BrokenString.fixString(brokenString);

        // Assert
        assertEquals(expectedString, actualString);
    }

    @Test
    void testFixString_WhenProvidedEmptyString_ReturnsEmptyString() {
        // Arrange
        String brokenString = "";

        // Act
        String actualString = BrokenString.fixString(brokenString);

        // Assert
        assertEquals("", actualString);
    }
}
