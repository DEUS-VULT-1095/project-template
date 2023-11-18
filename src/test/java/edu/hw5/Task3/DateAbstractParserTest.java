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

class DateAbstractParserTest {
    private DateAbstractParser parser;

    @BeforeEach
    void beforeEach() {
        parser = new DateAbstractParser() {
            @Override
            public Optional<LocalDate> parseDate(String string) {
                return Optional.of(LocalDate.parse("2023-01-01"));
            }
        };
    }

    @Test
    void testLink_whenProvidedParsers_returnsFirstParser() {
        // Arrange

        // Act
        DateAbstractParser actualParser = DateAbstractParser.link(parser);

        // Assert
        assertEquals(parser, actualParser);
    }

    @Test
    void testParseDate_whenProvidedString_returnsOptional() {
        // Arrange
        Optional<LocalDate> expectedOptional = Optional.of(LocalDate.of(2023, 1, 1));

        // Act
        Optional<LocalDate> actualOptional = parser.parseDate("someValue");

        // Assert
        assertEquals(expectedOptional, actualOptional);
    }

    @ParameterizedTest
    @MethodSource
    void testTryParse_whenProvidedValidValue_returnsOptional(String inputString, Optional<LocalDate> expectedOptional) {
        // Arrange
        DateAbstractParser parser1 = new DateAbstractParser() {
            @Override
            public Optional<LocalDate> parseDate(String string) {
                return string.equals("parser1") ? Optional.of(LocalDate.of(2023, 1, 1)) : Optional.empty();
            }
        };

        DateAbstractParser parser2 = new DateAbstractParser() {
            @Override
            public Optional<LocalDate> parseDate(String string) {
                return string.equals("parser2") ? Optional.of(LocalDate.of(2023, 2, 2)) : Optional.empty();
            }
        };

        DateAbstractParser chain = DateAbstractParser.link(parser1, parser2);

        // Act
        Optional<LocalDate> actualOptional = chain.tryParse(inputString);

        // Assert
        assertEquals(expectedOptional, actualOptional);
    }

    private static Stream<Arguments> testTryParse_whenProvidedValidValue_returnsOptional() {
        return Stream.of(
            Arguments.of("parser1", Optional.of(LocalDate.of(2023, 1, 1))),
            Arguments.of("parser2", Optional.of(LocalDate.of(2023, 2, 2))),
            Arguments.of("some", Optional.empty())
        );
    }
}
