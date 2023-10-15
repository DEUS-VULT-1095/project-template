package edu.hw1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class NestedArrayTest {

    @ParameterizedTest
    @MethodSource
    void testIsNestable_WhenNestableArraysInput_ReturnsTrue(int[] nestedArray, int[] extendedArray) {
        // Arrange

        // Act
        boolean isNestable = NestedArray.isNestable(nestedArray, extendedArray);

        // Assert
        assertTrue(isNestable);
    }

    private static Stream<Arguments> testIsNestable_WhenNestableArraysInput_ReturnsTrue() {
        return Stream.of(
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {0, 6}),
            Arguments.of(new int[] {3, 1}, new int[] {4, 0})
        );
    }

    @ParameterizedTest
    @MethodSource
    void testIsNestable_WhenNonNestableArraysInput_ReturnsFalse(int[] nestedArray, int[] extendArray) {
        // Arrange

        // Act
        boolean isNestable = NestedArray.isNestable(nestedArray, extendArray);

        // Assert
        assertFalse(isNestable);
    }

    private static Stream<Arguments> testIsNestable_WhenNonNestableArraysInput_ReturnsFalse() {
        return Stream.of(
            Arguments.of(new int[] {9, 9, 8}, new int[] {8, 9}),
            Arguments.of(new int[] {1, 2, 3, 4}, new int[] {2, 3})
        );
    }

    @Test
    void testIsNestable_WhenEmptyArraysInput_ReturnsFalse() {
        // Arrange
        int[] array1 = {};
        int[] array2 = {1, 1, 4};

        // Act
        boolean isNestable = NestedArray.isNestable(array1, array2);

        // Assert
        assertFalse(isNestable);
    }
}
