package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @DisplayName("Test clusterize method when provided valid data")
    @ParameterizedTest
    @MethodSource
    void testClusterize_whenProvidedValidString_returnsList(String providedString, List<String> expectedList) {
        // Arrange

        // Act
        List<String> actualList = Task2.clusterize(providedString);

        // Assert
        assertEquals(expectedList, actualList, "Expected list and actual list have not equals data");
    }

    private static Stream<Arguments> testClusterize_whenProvidedValidString_returnsList() {
        return Stream.of(
            Arguments.of("()()()", List.of("()", "()", "()")),
            Arguments.of("((()))", List.of("((()))")),
            Arguments.of("((()))(())()()(()())", List.of("((()))", "(())", "()", "()", "(()())")),
            Arguments.of("((())())(()(()()))", List.of("((())())", "(()(()()))"))
        );
    }

    @DisplayName("Test clusterize method when provided string not contain brackets")
    @Test
    void testClusterize_whenProvidedStringNotContainBrackets_throwsRuntimeException() {
        // Assert
        String providedString = "asdasi213ij";
        String exceptionMessage = "String not contain '(' and ')'";

        // Act & Assert
        RuntimeException actualException = assertThrows(RuntimeException.class, () -> Task2.clusterize(providedString),
            "Should be thrown RuntimeException");

        // Assert
        assertEquals(exceptionMessage, actualException.getMessage(), "Incorrect exception message");
    }

    @DisplayName("Test clusterize method when provided not balanced brackets")
    @Test
    void testClusterize_whenProvidedStringContainNotBalancedBrackets_throwsRuntimeException() {
        // Assert
        String providedString = "((())";
        String exceptionMessage = "Brackets are out of balance";

        // Act & Assert
        RuntimeException actualException = assertThrows(RuntimeException.class, () -> Task2.clusterize(providedString),
            "Should be thrown RuntimeException");

        // Assert
        assertEquals(exceptionMessage, actualException.getMessage(), "Incorrect exception message");
    }

    @DisplayName("Test clusterize method when provided string not contain only brackets")
    @Test
    void testClusterize_whenProvidedStringContainNotOnlyBrackets_throwsRuntimeException() {
        // Assert
        String providedString = "(asd1(()))";
        String exceptionMessage = "String must contain only '(' and ')'";

        // Act & Assert
        RuntimeException actualException = assertThrows(RuntimeException.class, () -> Task2.clusterize(providedString),
            "Should be thrown RuntimeException");

        // Assert
        assertEquals(exceptionMessage, actualException.getMessage(), "Incorrect exception message");
    }
}
