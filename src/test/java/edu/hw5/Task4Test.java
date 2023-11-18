package edu.hw5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @ParameterizedTest
    @ValueSource(strings = {"qwerty~", "e!wq", "jua@hgb", "#yat", "oik$j", "jih%ad", "hn^uj", "mj12&",
    "13*3", "312|d"})
    void testIsStrongPassword_whenProvidedStrongPassword_returnsTrue(String password) {
        // Arrange

        // Act
        boolean actualIsStrongPassword = Task4.isStrongPassword(password);

        // Assert
        assertTrue(actualIsStrongPassword);
    }

    @Test
    void testIsStrongPassword_whenProvidedWeakPassword_returnsFalse() {
        // Arrange
        String weakPassword = "alkjhsdnh123";

        // Act
        boolean actualIsStrongPassword = Task4.isStrongPassword(weakPassword);

        // Assert
        assertFalse(actualIsStrongPassword);
    }
}
