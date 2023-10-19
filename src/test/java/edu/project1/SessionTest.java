package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SessionTest {

    @DisplayName("Provided invalid riddle -> Thrown RuntimeException")
    @Test
    void testStartGame_whenProvidedInvalidRiddleWord_thrownRuntimeException() {
        // Arrange
        Dictionary testDictionary = new Dictionary() {
            @Override
            public String getWord() {
                return "";
            }
        };
        int maxAttempts = 5;
        Session session = new Session(testDictionary, maxAttempts);
        String expectedExceptionMessage = "Incorrect riddle word";

        // Act & Assert
        RuntimeException actualException = assertThrows(RuntimeException.class, session::startGame,
            "Should be thrown RuntimeException"
        );

        // Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }

    @DisplayName("Attempts exceeded -> lose message")
    @Test
    void testStartGame_whenMaxNumberOfAttemptsExceeded_outputLoseMessage()
        throws NoSuchFieldException, IllegalAccessException{
        // Arrange
        Dictionary dictionary = new MyDictionary();
        int maxAttempts = 5;
        Session session = new Session(dictionary, maxAttempts);

        Field currentMistakesField = session.getClass().getDeclaredField("currentMistakes");
        currentMistakesField.setAccessible(true);
        currentMistakesField.set(session, 5);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        String expectedOut = "You lost!";

        // Act
        session.startGame();

        // Assert
        assertEquals(expectedOut, byteArrayOutputStream.toString());
    }
}
