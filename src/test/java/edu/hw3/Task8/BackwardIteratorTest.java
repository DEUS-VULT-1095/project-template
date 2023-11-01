package edu.hw3.Task8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class BackwardIteratorTest {
    private BackwardIterator<Integer> backwardIterator1;
    private BackwardIterator<Integer> backwardIterator2;

    @BeforeEach
    void beforeEach() {
        backwardIterator1 = new BackwardIterator<>(List.of(1, 2, 3));
        backwardIterator2 = new BackwardIterator<>(List.of());
    }

    @Test
    void testHasNext_whenProvidedNotEmptyList_returnsTrue() {
        // Arrange

        // Act
        boolean actualResult = backwardIterator1.hasNext();

        // Assert
        assertTrue(actualResult, "Should returns ture");
    }

    @Test
    void testHasNext_whenProvidedEmptyList_returnsFalse() {
        // Arrange

        // Act
        boolean actualResult = backwardIterator2.hasNext();

        // Assert
        assertFalse(actualResult, "Should returns false");
    }

    @Test
    void testNext_whenProvidedNotNullList_returnsNextElement() {
        // Arrange
        int expectedResult = 3;

        // Act
        int actualResult = backwardIterator1.next();

        // Assert
        assertEquals(expectedResult, actualResult, () -> "Should returns " + expectedResult);
    }

    @Test
    void testNext_whenProvidedEmptyList_throwsNoSuchElementException() {
        // Arrange
        Class expectedExceptionClass = NoSuchElementException.class;

        // Act

        // Assert
        assertThrows(expectedExceptionClass, () -> backwardIterator2.next(),
            () -> "Should be thrown " + expectedExceptionClass.getName());
    }
}
