package edu.hw6;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @Test
    void testCloneFile_whenProvidedExistFileForCopy_copyFileWithNewName() throws IOException {
        // Arrange
        Path pathTempDir = Files.createDirectory(Paths.get("src", "main", "resources", "tempDir"));
        Path pathTempFile = Files.createTempFile(pathTempDir, "tempFile", ".txt");
        Files.writeString(pathTempFile, "some text");
        List<String> linesOfText = Files.readAllLines(pathTempFile);
        String pathWithoutSuffix = pathTempFile.toString()
            .substring(0, pathTempFile.toString().lastIndexOf("."));
        Path expectedPath2 = Paths.get(pathWithoutSuffix + " - копия.txt");
        Path expectedPath3 = Paths.get(pathWithoutSuffix + " - копия (1).txt");
        Path expectedPath4 = Paths.get(pathWithoutSuffix + " - копия (2).txt");

        // Act
        Task2.cloneFile(pathTempFile);
        Task2.cloneFile(pathTempFile);
        Task2.cloneFile(pathTempFile);

        // Assert
        assertTrue(Files.exists(expectedPath2));
        assertTrue(Files.exists(expectedPath3));
        assertTrue(Files.exists(expectedPath4));
        assertEquals(Files.readAllLines(expectedPath2), linesOfText);
        assertEquals(Files.readAllLines(expectedPath3), linesOfText);
        assertEquals(Files.readAllLines(expectedPath4), linesOfText);

        Files.walkFileTree(pathTempDir, EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    @Test
    void testCloneFile_whenProvidedNotExistFileForCopy_thrownRuntimeException() {
        // Arrange
        String expectedExceptionMessage = "File for copy not found";

        // Act & Assert
        RuntimeException actualException = assertThrows(RuntimeException.class,
            () -> Task2.cloneFile(Paths.get("not exist file path")));

        // Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage());
    }
}
