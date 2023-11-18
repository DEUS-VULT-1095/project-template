package edu.hw6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class DiskMapTest {
    private static Path tempPath;
    private static DiskMap diskMap;
    private final String key1 = "key1";
    private final String value1 = "value1";
    private final String key2 = "key2";
    private final String value2 = "value2";

    @BeforeAll
    static void beforeAll() throws IOException {
        tempPath = Files.createTempFile("tempFile", ".txt");
        diskMap = new DiskMap(tempPath.toString());

    }

    @BeforeEach
    void beforeEach() throws IOException {
        Files.writeString(tempPath, key1 + ":" + value1 + "\n" + key2 + ":" + value2 + "\n");
    }

    @AfterAll
    static void afterAll() throws IOException {
        Files.deleteIfExists(tempPath);
    }

    @Test
    void testSize_whenMethodCallsDiskMap_returnsSizeOfDiskMap() throws IOException {
        // Arrange
        int expectedSize = Files.readAllLines(tempPath).size();

        // Act & Assert
        int actualSize = diskMap.size();

        // Assert
        assertEquals(expectedSize, actualSize);
    }

    @Test
    void testIsEmpty_whenProvidedNotEmptyDiskMap_returnsFalse() {
        // Arrange

        // Act
        boolean actualResult = diskMap.isEmpty();

        // Assert
        assertFalse(actualResult);
    }

    @Test
    void testIsEmpty_whenProvidedEmptyDiskMap_returnsTrue() throws IOException {
        // Arrange
        Files.writeString(tempPath, "");

        // Act
        boolean actualResult = diskMap.isEmpty();

        // Assert
        assertTrue(actualResult);
    }

    @Test
    void testContainsKey_whenProvidedExistKey_returnsTrue() {
        // Arrange

        // Act
        boolean actualResult = diskMap.containsKey(key1);

        // Assert
        assertTrue(actualResult);
    }

    @Test
    void testContainsKey_whenProvidedNotExistKey_returnsFalse() {
        // Arrange

        // Act
        boolean actualResult = diskMap.containsKey("notExistKey");

        // Assert
        assertFalse(actualResult);
    }

    @Test
    void testContainsValue_whenProvidedExistValue_returnsTrue() {
        // Arrange

        // Act
        boolean actualResult = diskMap.containsValue(value1);

        // Assert
        assertTrue(actualResult);
    }

    @Test
    void testContainsValue_whenProvidedNotExistValue_returnsFalse() {
        // Arrange

        // Act
        boolean actualResult = diskMap.containsValue("notExistValue");

        // Assert
        assertFalse(actualResult);
    }

    @Test
    void testGet_whenProvidedExistKeyDiskMap_returnsValue() {
        // Arrange

        // Act
        String actualValue = diskMap.get(key1);

        // Assert
        assertEquals(value1, actualValue);
    }

    @Test
    void testPut_whenProvidedExistKey_returnsOldValue() {
        // Arrange
        String newValue = "newValue";

        // Act
        String actualOldValue = diskMap.put(key1, newValue);

        // Assert
        assertEquals(value1, actualOldValue);
    }

    @Test
    void testPut_whenProvidedNotExistKey_returnsNull() {
        // Arrange
        String key = "notExistKey";
        String newValue = "value";
        String expectedOldValue = null;

        // Act
        String actualOldValue = diskMap.put(key, newValue);

        // Assert
        assertEquals(expectedOldValue, actualOldValue);
    }

    @Test
    void testRemove_whenProvidedExistKey_returnsDeletedValue() throws IOException {
        // Arrange

        // Act
        String actualDeletedValue = diskMap.remove(key1);
        List<String> allLines = Files.readAllLines(tempPath);

        // Assert
        assertEquals(value1, actualDeletedValue);
        assertTrue(allLines.stream().filter(next -> next.startsWith(key1)).findAny().isEmpty());
    }

    @Test
    void testPutAll_whenProvidedMap_putAllMap() throws IOException {
        // Arrange
        String key3 = "key3";
        String value3 = "value3";
        String key4 = "key4";
        String value4 = "value4";

        Map<String, String> anotherMap = Map.of(key3, value3, key4, value4);

        List<String> expectedAllLines = List.of(
            key1 + ":" + value1,
            key2 + ":" + value2,
            key3 + ":" + value3,
            key4 + ":" + value4
        );

        // Act
        diskMap.putAll(anotherMap);
        List<String> actualAllLines = Files.readAllLines(tempPath);

        // Assert
        assertEquals(expectedAllLines, actualAllLines);
    }

    @Test
    void testClear_whenMethodeCallsDiskMap_deleteAllElements() throws IOException {
        // Arrange
        long expectedFileSize = 0;

        // Act
        diskMap.clear();
        long actualFileSize = Files.size(tempPath);

        // Assert
        assertEquals(expectedFileSize, actualFileSize);
    }

    @Test
    void testKeySet_whenDiskMapNotEmpty_returnsKeySet() throws IOException {
        // Arrange
        Set<String> expectedKeySet = new HashSet<>();
        expectedKeySet.add(key1);
        expectedKeySet.add(key2);

        // Act
        Set<String> actualKeySet = diskMap.keySet();

        // Assert
        assertEquals(expectedKeySet, actualKeySet);
    }

    @Test
    void testValues_whenDiskMapNotEmpty_returnsCollectionOfValues() {
        // Arrange
        List<String> expectedValueList = List.of(value1, value2);

        // Act
        List<String> actualValueList = diskMap.values().stream().toList();

        // Assert
        assertEquals(expectedValueList, actualValueList);
    }

    @Test
    void testEntrySet_whenDiskMapNotEmpty_returnsEntrySet() {
        // Arrange
        Map<String, String> map = new HashMap<>();
        map.put(key1, value1);
        map.put(key2, value2);
        Set<Map.Entry<String, String>> expectedEntrySet = map.entrySet();

        // Act
        Set<Map.Entry<String, String >> actualEntrySet = diskMap.entrySet();

        // Assert
        assertEquals(expectedEntrySet, actualEntrySet);
    }
}
