package edu.hw3.Task7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyComparatorTest {
    private MyComparator myComparator = new MyComparator();

    @Test
    void testCompare_whenFirstParameterIsNull_returnsNegativeValue() {
        // Arrange
        String str1 = null;
        String str2 = "not null";
        int expectedResult = -1;

        // Act
        int actualResult = myComparator.compare(str1, str2);

        // Assert
        assertEquals(expectedResult, actualResult, "Should returns -1");
    }

    @Test
    void testCompare_whenSecondParameterIsNull_returnsPositiveValue() {
        // Arrange
        String str1 = "not null";
        String str2 = null;
        int expectedResult = 1;

        // Act
        int actualResult = myComparator.compare(str1, str2);

        // Assert
        assertEquals(expectedResult, actualResult, "Should returns 1");
    }
}
