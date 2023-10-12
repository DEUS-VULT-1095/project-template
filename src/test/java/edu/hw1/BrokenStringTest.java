package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrokenStringTest {

    @Test
    void testFixString_WhenBrokenStringInput_ReturnsFixedString() {
        // Arrange
        String brokenStr1 = "123456";
        String brokenStr2 = "hTsii  s aimex dpus rtni.g";

        // Act
        String fixedStr1 = BrokenString.fixString(brokenStr1);
        String fixedStr2 = BrokenString.fixString(brokenStr2);

        // Assert
        assertEquals("214365", fixedStr1);
        assertEquals("This is a mixed up string.", fixedStr2);
    }

    @Test
    void testFixString_WhenProvidedStringWithOddNumberOfCharacters_ReturnsFixedString() {
        // Arrange
        String brokenStr1 = "badce";
        String brokenStr2 = "w";

        // Act
        String fixedStr1 = BrokenString.fixString(brokenStr1);
        String fixedStr2 = BrokenString.fixString(brokenStr2);

        // Assert
        assertEquals("abcde", fixedStr1);
        assertEquals("w", fixedStr2);
    }

    @Test
    void testFixString_WhenProvidedEmptyString_ReturnsEmptyString() {
        // Arrange
        String brokenStr = "";

        // Act
        String fixedStr = BrokenString.fixString(brokenStr);

        // Assert
        assertEquals("", fixedStr);
    }
}
