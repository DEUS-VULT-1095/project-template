package edu.project1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class MyDictionaryTest {

    @DisplayName("Returns word")
    @Test
    void testGetWord_returnsWord() {
        // Arrange
        Dictionary dictionary = new Dictionary() {
            @Override
            public String getWord() {
                return "random word";
            }
        };
        String expectedWord = "random word";

        // Act
        String actualWord = dictionary.getWord();

        // Assert
        assertEquals(expectedWord, actualWord);
    }
}
