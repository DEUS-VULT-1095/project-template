package edu.hw1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CyclicBitShiftTest {

    @Test
    void testRotateRight_WhenProvidedValidData_ReturnsNumber() {
        // Arrange
        int number1 = 8;
        int shift1 = 1;
        int number2 = 5;
        int shift2 = 2;
        int number3 = 0;
        int shift3 = 2;
        int number4 = 1;
        int shift4 = 0;

        // Act
        int result1 = CyclicBitShift.rotateRight(number1, shift1);
        int result2 = CyclicBitShift.rotateRight(number2, shift2);
        int result3 = CyclicBitShift.rotateRight(number3, shift3);
        int result4 = CyclicBitShift.rotateRight(number4, shift4);

        // Assert
        assertEquals(4, result1);
        assertEquals(3, result2);
        assertEquals(0, result3);
        assertEquals(1, result4);
    }

    @Test
    void testRotateRight_WhenProvidedInvalidData_ThrowRuntimeException() {
        // Arrange
        int number1 = -2;
        int shift1 = 1;
        int number2 = 5;
        int shift2 = -2;

        // Act

        // Assert
        assertThrows(RuntimeException.class, () -> CyclicBitShift.rotateRight(number1, shift1));
        assertThrows(RuntimeException.class, () -> CyclicBitShift.rotateRight(number2, shift2));
    }

    @Test
    void testRotateLeft_WhenProvidedValidData_ReturnsNumber() {
        // Arrange
        int number1 = 16;
        int shift1 = 1;
        int number2 = 17;
        int shift2 = 2;
        int number3 = 0;
        int shift3 = 2;
        int number4 = 1;
        int shift4 = 0;

        // Act
        int result1 = CyclicBitShift.rotateLeft(number1, shift1);
        int result2 = CyclicBitShift.rotateLeft(number2, shift2);
        int result3 = CyclicBitShift.rotateLeft(number3, shift3);
        int result4 = CyclicBitShift.rotateLeft(number4, shift4);

        // Assert
        assertEquals(1, result1);
        assertEquals(6, result2);
        assertEquals(0, result3);
        assertEquals(1, result4);
    }

    @Test
    void testRotateLeft_WhenProvidedInvalidData_ThrowRuntimeException() {
        // Arrange
        int number1 = -2;
        int shift1 = 1;
        int number2 = 5;
        int shift2 = -2;

        // Act

        // Assert
        assertThrows(RuntimeException.class, () -> CyclicBitShift.rotateLeft(number1, shift1));
        assertThrows(RuntimeException.class, () -> CyclicBitShift.rotateLeft(number2, shift2));
    }

    @Test
    void testRotateRightVersionTwo_whenProvidedValidData_returnsNumber() {
        // Arrange
        int number1 = 8;
        int shift1 = 1;
        int number2 = 5;
        int shift2 = 2;
        int number3 = 0;
        int shift3 = 2;
        int number4 = 1;
        int shift4 = 0;

        // Act
        int result1 = CyclicBitShift.rotateRightVersionTwo(number1, shift1);
        int result2 = CyclicBitShift.rotateRightVersionTwo(number2, shift2);
        int result3 = CyclicBitShift.rotateRightVersionTwo(number3, shift3);
        int result4 = CyclicBitShift.rotateRightVersionTwo(number4, shift4);

        // Assert
        assertEquals(4, result1);
        assertEquals(3, result2);
        assertEquals(0, result3);
        assertEquals(1, result4);
    }

    @Test
    void testRotateRightVersionTwo_WhenProvidedInvalidData_ThrowRuntimeException() {
        // Arrange
        int number1 = -2;
        int shift1 = 1;
        int number2 = 5;
        int shift2 = -2;

        // Act

        // Assert
        assertThrows(RuntimeException.class, () -> CyclicBitShift.rotateRightVersionTwo(number1, shift1));
        assertThrows(RuntimeException.class, () -> CyclicBitShift.rotateRightVersionTwo(number2, shift2));
    }

    @Test
    void testRotateLeftVersionTwo_WhenProvidedValidData_ReturnsNumber() {
        // Arrange
        int number1 = 16;
        int shift1 = 1;
        int number2 = 17;
        int shift2 = 2;
        int number3 = 0;
        int shift3 = 2;
        int number4 = 1;
        int shift4 = 0;

        // Act
        int result1 = CyclicBitShift.rotateLeftVersionTwo(number1, shift1);
        int result2 = CyclicBitShift.rotateLeftVersionTwo(number2, shift2);
        int result3 = CyclicBitShift.rotateLeftVersionTwo(number3, shift3);
        int result4 = CyclicBitShift.rotateLeftVersionTwo(number4, shift4);

        // Assert
        assertEquals(1, result1);
        assertEquals(6, result2);
        assertEquals(0, result3);
        assertEquals(1, result4);
    }

    @Test
    void testRotateLeftVersionTwo_WhenProvidedInvalidData_ThrowRuntimeException() {
        // Arrange
        int number1 = -2;
        int shift1 = 1;
        int number2 = 5;
        int shift2 = -2;

        // Act

        // Assert
        assertThrows(RuntimeException.class, () -> CyclicBitShift.rotateLeftVersionTwo(number1, shift1));
        assertThrows(RuntimeException.class, () -> CyclicBitShift.rotateLeftVersionTwo(number2, shift2));
    }
}
