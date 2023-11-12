package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @ParameterizedTest
    @MethodSource
    void testGetSeveralDuration_whenProvidedVarargs_returnsString(String expectedOutput, String... inputLines) {
        // Arrange

        // Act
        String actualOutput = Task1.getSeveralDuration(inputLines);

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }

    private static Stream<Arguments> testGetSeveralDuration_whenProvidedVarargs_returnsString() {
        return Stream.of(
            Arguments.of("3ч 40м", new String[] {"2022-03-12, 20:20 - 2022-03-12, 23:50",
                "2022-04-01, 21:30 - 2022-04-02, 01:20"}),
            Arguments.of("3ч 30м", new String[] {"2022-03-12, 20:20 - 2022-03-12, 23:50"})
        );
    }
}
