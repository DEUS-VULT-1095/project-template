package edu.hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @ParameterizedTest
    @CsvSource({
        "achfdbaabgabcaabg,abc",
        "iouahedasdipuqhwea[odpifgj,aie",
    })
    void testIsSubsequence_whenProvidedSubsequence_returnsTrue(String inputString, String patternString) {
        // Arrange

        // Act
        boolean isSubsequence = Task6.isSubsequence(inputString, patternString);

        // Assert
        assertTrue(isSubsequence);
    }

    @Test
    void testIsSubsequence_whenProvidedEmptyPattern_returnsTrue() {
        // Arrange
        String patternString = "";
        String inputString = "dakjhifhnsdjokf";

        // Act
        boolean isSubsequence = Task6.isSubsequence(inputString, patternString);

        // Assert
        assertTrue(isSubsequence);
    }

    @ParameterizedTest
    @CsvSource({
        "achfdbaabgabcaabg,acbf",
        "achfdbaabgabcaabg,gacf"
    })
    void testIsSubsequence_whenProvidedNoSubsequence_returnsFalse(String inputString, String patternString) {
        // Arrange

        // Act
        boolean isSubsequence = Task6.isSubsequence(inputString, patternString);

        // Assert
        assertFalse(isSubsequence);
    }
}
