package edu.hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {

    @ParameterizedTest
    @ValueSource(strings = {"А123ВЕ777", "О777ОО177"})
    void testIsValidNumberPlate_whenProvidedValidPlateNumber_returnsTrue(String numberPlate) {
        // Arrange

        // Act
        boolean actualIsValidPlateNumber = Task5.isValidNumberPlate(numberPlate);

        // Assert
        assertTrue(actualIsValidPlateNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123АВЕ777", "А123ВГ77", "А123ВЕ7777"})
    void testIsValidNumberPlate_whenProvidedInvalidPlateNumber_returnsFalse(String numberPlate) {
        // Arrange

        // Act
        boolean actualIsValidPlateNumber = Task5.isValidNumberPlate(numberPlate);

        // Assert
        assertFalse(actualIsValidPlateNumber);
    }
}
