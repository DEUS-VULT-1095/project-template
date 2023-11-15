package edu.hw6.Task3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FiltersTest {
    private static Path pathTempDir1;
    private static Path pathTempDir2;
    private static Path pathTempFile1;
    private static Path pathTempFile2;
    private static Path pathTempFile3;
    private static DirectoryStream.Filter<Path> filter;

    @BeforeAll
    static void beforeAll() throws IOException {
        pathTempDir1 = Files.createDirectory(Paths.get("src", "main", "resources", "tempDir"));
        pathTempDir2 = Files.createDirectory(Paths.get(pathTempDir1.toString(), "dir2"));
        // 437 bite
        pathTempFile1 = Files.createTempFile(pathTempDir1, "tempFile1", ".txt");
        // 241 bite
        pathTempFile2 = Files.createTempFile(pathTempDir1, "tempFile2", ".txt");
        pathTempFile3 = Files.createTempFile(pathTempDir1, "tempFile3", ".odt");
        Files.writeString(pathTempFile1,
            "Alle Vögel sind schon da, alle Vögel, alle!\n" +
                "\n" +
                "Welch ein Singen, Musizieren,\n" +
                "\n" +
                "Pfeifen, Zwitschern, Tirilieren!\n" +
                "\n" +
                "Frühling will nun einmarschiern,\n" +
                "\n" +
                "kommt mit Sang und Schalle.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Wie sie alle lustig sind, flink und froh sich regen!\n" +
                "\n" +
                "\n" +
                "und die ganze Vogelschar\n" +
                "\n" +
                "wünschen dir ein frohes Jahr,\n" +
                "\n" +
                "lauter Heil und Segen.\n" +
                "\n" +
                " \n" +
                "\n" +
                "\n" +
                "alle wolln wir lustig sein,\n" +
                "\n" +
                "lustig wie die Vögelein,\n" +
                "\n" +
                "hier und dort, feldaus, feldein,\n" +
                "\n" +
                "springen, tanzen, scherzen."
        );
        Files.writeString(pathTempFile2,
            "Liebe Sonne, scheine wieder,\n" +
                "\n" +
                "schein die düstern Wolken nieder!\n" +
                "\n" +
                "Komm mit deinem goldnen Strahl\n" +
                "\n" +
                "wieder über Berg und Tal!\n" +
                "\n" +
                "Trockne ab auf allen Wegen\n" +
                "\n" +
                "überall den alten Regen!\n" +
                "\n" +
                "Liebe Sonne, lass dich sehn,\n" +
                "\n" +
                "dass wir können spielen gehn!"
        );
    }

    @AfterAll
    static void afterAll() throws IOException {
        Files.delete(pathTempFile1);
        Files.delete(pathTempFile2);
        Files.delete(pathTempFile3);
        Files.delete(pathTempDir2);
        Files.delete(pathTempDir1);
    }

    @Test
    void testFileSize() throws IOException {
        // Arrange
        int minSize = 250;
        int maxSize = 500;
        filter = Filters.fileSize(minSize, maxSize);
        List<Path> expectedList = new ArrayList<>();
        expectedList.add(pathTempFile1.toAbsolutePath());

        // Act
        DirectoryStream<Path> entries = Files.newDirectoryStream(pathTempDir1, filter);
        List<Path> actualList = new ArrayList<>();
        entries.forEach(e -> actualList.add(e.toAbsolutePath()));
        entries.close();

        // Assert
        assertEquals(expectedList, actualList);
    }

    @Test
    void testExtension() throws IOException {
        // Arrange
        List<Path> expectedList = new ArrayList<>();
        expectedList.add(pathTempFile3.toAbsolutePath());
        filter = Filters.extension("odt");

        // Act
        DirectoryStream<Path> entries = Files.newDirectoryStream(pathTempDir1, filter);
        List<Path> actualList = new ArrayList<>();
        entries.forEach(e -> actualList.add(e.toAbsolutePath()));
        entries.close();

        // Assert
        assertEquals(expectedList, actualList);
    }

    @Test
    void testRegexMatches() throws IOException {
        // Arrange
        List<Path> expectedList = new ArrayList<>();
        expectedList.add(pathTempFile3.toAbsolutePath());
        filter = Filters.regexMatches("^t.*\\.odt$");

        // Act
        DirectoryStream<Path> entries = Files.newDirectoryStream(pathTempDir1, filter);
        List<Path> actualList = new ArrayList<>();
        entries.forEach(e -> actualList.add(e.toAbsolutePath()));
        entries.close();

        // Assert
        assertEquals(expectedList, actualList);
    }

    @Test
    void testMagicNumber() throws IOException {
        // Arrange
        byte[] bytes = Files.lines(pathTempFile1).findFirst().get().getBytes(StandardCharsets.UTF_8);
        int[] intArray = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            intArray[i] = bytes[i] & 0xFF;
        }
        filter = Filters.magicNumber(intArray);
        List<Path> expectedList = new ArrayList<>();
        expectedList.add(pathTempFile1.toAbsolutePath());

        // Act
        DirectoryStream<Path> entries = Files.newDirectoryStream(pathTempDir1, filter);
        List<Path> actualList = new ArrayList<>();
        entries.forEach(e -> actualList.add(e.toAbsolutePath()));
        entries.close();

        // Assert
        assertEquals(expectedList, actualList);
    }

    @Test
    void testRegularFile() throws IOException {
        // Arrange
        filter = Filters.REGULAR_FILE;
        List<Path> expectedList = new ArrayList<>();
        expectedList.add(pathTempFile1.toAbsolutePath());
        expectedList.add(pathTempFile2.toAbsolutePath());
        expectedList.add(pathTempFile3.toAbsolutePath());

        // Act
        DirectoryStream<Path> entries = Files.newDirectoryStream(pathTempDir1, filter);
        List<Path> actualList = new ArrayList<>();
        entries.forEach(e -> actualList.add(e.toAbsolutePath()));
        entries.close();

        // Assert
        assertEquals(expectedList, actualList);
    }

    @Test
    void testReadable() throws IOException {
        // Arrange
        filter = Filters.READABLE;
        List<Path> expectedList = new ArrayList<>();
        expectedList.add(pathTempDir2.toAbsolutePath());
        expectedList.add(pathTempFile1.toAbsolutePath());
        expectedList.add(pathTempFile2.toAbsolutePath());
        expectedList.add(pathTempFile3.toAbsolutePath());

        // Act
        DirectoryStream<Path> entries = Files.newDirectoryStream(pathTempDir1, filter);
        List<Path> actualList = new ArrayList<>();
        entries.forEach(e -> actualList.add(e.toAbsolutePath()));
        entries.close();

        // Assert
        assertTrue(expectedList.size() == actualList.size() && expectedList.containsAll(actualList));
    }

    @Test
    void testWritable() throws IOException {
        // Arrange
        filter = Filters.WRITABLE;
        List<Path> expectedList = new ArrayList<>();
        expectedList.add(pathTempFile1.toAbsolutePath());
        expectedList.add(pathTempFile2.toAbsolutePath());
        expectedList.add(pathTempFile3.toAbsolutePath());
        expectedList.add(pathTempDir2.toAbsolutePath());

        // Act
        DirectoryStream<Path> entries = Files.newDirectoryStream(pathTempDir1, filter);
        List<Path> actualList = new ArrayList<>();
        entries.forEach(e -> actualList.add(e.toAbsolutePath()));
        entries.close();

        // Assert
        assertTrue(expectedList.size() == actualList.size() && expectedList.containsAll(actualList));
    }
}
