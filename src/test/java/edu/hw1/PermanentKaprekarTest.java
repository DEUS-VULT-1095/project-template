package edu.hw1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PermanentKaprekarTest {

    @ParameterizedTest
    @CsvSource({
        "6621, 5",
        "6554, 4",
        "1234, 3",
        "1000, 5",
        "9998, 5"
    })
    void testCountK_WhenProvidedValidNumber_ReturnsNumberIterations(int providedNumber, int expectedIterationCount) {
        // Arrange

        // Act
        int actualIterationCount = PermanentKaprekar.countK(providedNumber);

        // Assert
        assertEquals(expectedIterationCount, actualIterationCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, 9999, 10000})
    void testCountK_WhenProvidedInvalidNumber_ThrowRuntimeException(int providedNumber) {
        // Arrange
        String expectedExceptionMessage = "The boundaries of the incoming value are violated";

        // Act
        RuntimeException actualException = assertThrows(RuntimeException.class,
            () -> PermanentKaprekar.countK(providedNumber), "Should have thrown Runtime exception");

        // Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Incorrect exception message");
    }
}
