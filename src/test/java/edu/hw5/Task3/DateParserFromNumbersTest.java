package edu.hw5.Task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class DateParserFromNumbersTest {
    private DateParserFromNumbers dateParserFromNumbers;

    @BeforeEach
    void beforeEach() {
        dateParserFromNumbers = new DateParserFromNumbers();
    }

    @ParameterizedTest
    @MethodSource
    void testParseDate_whenProvidedValidValue_returnsOptional(String inputString, Optional expectedOptional) {
        // Arrange

        // Act
        Optional<LocalDate> actualOptional = dateParserFromNumbers.parseDate(inputString);

        // Assert
        assertEquals(expectedOptional, actualOptional);
    }

    private static Stream<Arguments> testParseDate_whenProvidedValidValue_returnsOptional() {
        return Stream.of(
            Arguments.of("2020-10-10", Optional.of(LocalDate.of(2020, 10, 10))),
            Arguments.of("2020-12-2", Optional.of(LocalDate.of(2020, 12, 2))),
            Arguments.of("1/3/1976", Optional.of(LocalDate.of(1976, 3, 1))),
            Arguments.of("1/3/20", Optional.of(LocalDate.of(2020, 3, 1)))
        );
    }

    @Test
    void testParseDate_whenProvidedInvalidValue_returnsEmptyOptional() {
        // Arrange
        String inputString = "tomorrow";
        Optional expectedOptional = Optional.empty();

        // Act
        Optional actualOptional = dateParserFromNumbers.parseDate(inputString);

        // Assert
        assertEquals(expectedOptional, actualOptional);
    }
}
