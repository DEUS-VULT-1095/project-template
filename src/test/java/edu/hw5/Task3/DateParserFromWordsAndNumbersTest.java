package edu.hw5.Task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class DateParserFromWordsAndNumbersTest {
    private DateParserFromWordsAndNumbers dateParserFromWordsAndNumbers;

    @BeforeEach
    void beforeEach() {
        dateParserFromWordsAndNumbers = new DateParserFromWordsAndNumbers();
    }

    @ParameterizedTest
    @MethodSource
    void testParseDate_whenProvidedValidValue_returnsOptional(String inputString, Optional expectedOptional) {
        // Arrange

        // Act
        Optional<LocalDate> actualOptional = dateParserFromWordsAndNumbers.parseDate(inputString);

        // Assert
        assertEquals(expectedOptional, actualOptional);
    }

    private static Stream<Arguments> testParseDate_whenProvidedValidValue_returnsOptional() {
        return Stream.of(
            Arguments.of("1 day ago", Optional.of(LocalDate.now().minusDays(1))),
            Arguments.of("2234 days ago", Optional.of(LocalDate.now().minusDays(2234)))
        );
    }
}
