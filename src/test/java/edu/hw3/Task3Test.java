package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class Task3Test {

    @ParameterizedTest
    @MethodSource
    void testFreqDict_whenProvidedListOfObjects_returnsMap(List providedList, Map expectedMap) {
        // Arrange

        // Act
        Map actualMap = Task3.freqDict(providedList);

        // Assert
        assertAll(
            () -> assertEquals(expectedMap.size(), actualMap.size(), "Should be equals size of Map"),
            () -> assertEquals(expectedMap, actualMap, "Should contain equals data")
        );

    }

    private static Stream<Arguments> testFreqDict_whenProvidedListOfObjects_returnsMap() {
        return Stream.of(
            Arguments.of(List.of("a", "bb", "a", "bb"), Map.of("bb", 2, "a", 2)),
            Arguments.of(List.of("this", "and", "that", "and"), Map.of("that", 1, "and", 2, "this", 1)),
            Arguments.of(List.of(1, 1, 2, 2), Map.of(1, 2, 2, 2))
        );
    }
}
