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

class DateParserFromWordsTest {
    private DateParserFromWords dateParserFromWords;

    @BeforeEach
    void beforeEach() {
        dateParserFromWords = new DateParserFromWords();
    }

    @ParameterizedTest
    @MethodSource
    void testParseDate_whenProvidedValidValue_returnsOptional(String inputString, Optional<LocalDate> expectedOptional) {
        // Arrange

        // Act
        Optional<LocalDate> actualOptional = dateParserFromWords.parseDate(inputString);

        // Assert
        assertEquals(expectedOptional, actualOptional);
    }

    private static Stream<Arguments> testParseDate_whenProvidedValidValue_returnsOptional() {
        return Stream.of(
            Arguments.of("tomorrow", Optional.of(LocalDate.now().plusDays(1))),
            Arguments.of("today", Optional.of(LocalDate.now())),
            Arguments.of("yesterday", Optional.of(LocalDate.now().minusDays(1)))
        );
    }

    @Test
    void testParseDate_whenProvidedInvalidValue_returnsEmptyOptional() {
        // Arrange
        String inputString = "1 day ago";
        Optional expectedOptional = Optional.empty();

        // Act
        Optional actualOptional = dateParserFromWords.parseDate(inputString);

        // Assert
        assertEquals(expectedOptional, actualOptional);
    }
}
