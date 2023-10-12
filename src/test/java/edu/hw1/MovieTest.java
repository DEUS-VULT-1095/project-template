package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @ParameterizedTest
    @CsvSource({
        "1:00, 60",
        "13:56, 836",
        "00:59, 59"
    })
    void testMinutesToSeconds_WhenValidInput_ReturnsTotalSeconds(String providedTime, int expectedSeconds) {
        // Arrange

        // Act
        int actualSeconds = Movie.minutesToSeconds(providedTime);

        // Assert
        assertEquals(expectedSeconds, actualSeconds);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10:60", "10:-1", "asd:10", "10:asd", "asd:asds"})
    void testMinutesToSeconds_WhenInvalidInput_ReturnsMinusOne(String providedTime) {
        // Arrange
        int expectedResult = -1;

        // Act
        int actualSeconds = Movie.minutesToSeconds(providedTime);

        // Assert
        assertEquals(expectedResult, actualSeconds);
    }
}
