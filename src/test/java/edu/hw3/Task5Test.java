package edu.hw3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    private List<String> contactList = new ArrayList<>();

    @BeforeEach
    void beforeEach() {
        contactList.add("John Locke");
        contactList.add("Thomas Aquinas");
        contactList.add("David Hume");
        contactList.add("Rene Descartes");
    }

    @DisplayName("Test ASC sort")
    @Test
    void testParseContacts_whenAscSort_returnsSortedList() {
        // Arrange
        List<String> expectedContactList =
            Arrays.asList("Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke");

        // Act
        List<String> actualList = Task5.parseContacts(contactList, "ASC");

        // Assert
        assertEquals(expectedContactList, actualList, "List should be sorted by ASC");
    }

    @DisplayName("Test DESC sort")
    @Test
    void testParseContacts_whenDescSort_returnSortedList() {
        // Arrange
        List<String> expectedContactList =
            Arrays.asList("John Locke", "David Hume", "Rene Descartes", "Thomas Aquinas");

        // Act
        List<String> actualList = Task5.parseContacts(contactList, "DESC");

        // Assert
        assertEquals(expectedContactList, actualList, "List should be sorted by DESC");
    }

    @DisplayName("Test throw exception when provided incorrect sort type")
    @Test
    void testParseContacts_whenProvidedInvalidSortType_throwsRuntimeException() {
        // Arrange
        String expectedExceptionMessage = "Wrong sort type";

        // Act
        RuntimeException actualException = assertThrows(RuntimeException.class,
            () -> Task5.parseContacts(contactList, "WTF"), "Should be thrown Runtime Exception"
        );

        // Assert
        assertEquals(expectedExceptionMessage, actualException.getMessage(), "Wrong exception message");
    }

    @DisplayName("Test ASC sort when provided names without surname")
    @Test
    void testParseContacts_whenProvidedNamesWithoutSurnameASC_returnsSortedList() {
        // Arrange
        String name1 = "Aabby";
        String name2 = "Zubra";
        contactList.add(name1);
        contactList.add(name2);
        List<String> expectedList = Arrays.asList(
            name1, "Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke", name2);

        // Act
        List<String> actualList = Task5.parseContacts(contactList, "ASC");

        // Assert
        assertEquals(expectedList, actualList, "Not equals actual and expected List");
    }

    @DisplayName("Test DESC sort when provided names without surname")
    @Test
    void testParseContacts_whenProvidedNamesWithoutSurnameDESC_returnsSortedList() {
        // Arrange
        String name1 = "Aabby";
        String name2 = "Zubra";
        contactList.add(name1);
        contactList.add(name2);
        List<String> expectedList = Arrays.asList(
            name1, "Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke", name2).reversed();

        // Act
        List<String> actualList = Task5.parseContacts(contactList, "DESC");

        // Assert
        assertEquals(expectedList, actualList, "Not equals actual and expected List");
    }
}
