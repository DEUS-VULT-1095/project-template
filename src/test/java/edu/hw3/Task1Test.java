package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @DisplayName("Test encoding")
    @ParameterizedTest
    @CsvSource(
        {"I hate testing., R szgv gvhgrmt.",
        "Убежище 231 in danger!, Убежище 231 rm wzmtvi!",
        "`~}{[]?@#$%^&(*(), `~}{[]?@#$%^&(*()"}
    )
    void testEncode_whenProvidedString_returnsEncodedString(String providedString, String expectedString) {
        // Arrange

        // Act
        String actualString = Task1.encode(providedString);

        // Assert
        assertEquals(expectedString, actualString, "Should return correct encode string");
    }
}
