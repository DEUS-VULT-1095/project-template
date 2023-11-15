package edu.hw6;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task4Test {

    @Test
    void testSomePrint() throws IOException {
        // Arrange
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Programming is learned by writing programs. ― Brian Kernighan");
        Path path = Paths.get("src", "main", "resources", "tempFile.txt");

        // Act
        Task4.somePrint();
        List<String> actualsList = Files.readAllLines(path);

        // Assert
        assertEquals(expectedList, actualsList);
        Files.delete(path);
    }
}
