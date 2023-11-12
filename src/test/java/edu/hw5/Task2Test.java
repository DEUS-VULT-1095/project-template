package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class Task2Test {

    @ParameterizedTest
    @MethodSource
    void testGetFridayTheThirteenth_whenProvidedYear_returnsLocalDate(int year, List<LocalDate> expectedDateList) {
        // Arrange

        // Act
        List<LocalDate> actualDateList = Task2.getFridayTheThirteenth(year);

        // Assert
        assertEquals(expectedDateList, actualDateList);
    }

    private static Stream<Arguments> testGetFridayTheThirteenth_whenProvidedYear_returnsLocalDate() {
        return Stream.of(
            Arguments.of(1925, List.of(LocalDate.of(1925, 2, 13), LocalDate.of(1925, 3, 13), LocalDate.of(1925, 11, 13))),
            Arguments.of(2024, List.of(LocalDate.of(2024, 9, 13), LocalDate.of(2024, 12, 13)))
        );
    }

    @ParameterizedTest
    @MethodSource
    void testGetNextFridayTheThirteenth_whenProvidedLocalDate_returnsLocalDate(LocalDate providedDate,
        LocalDate expectedDate) {
        // Arrange

        // Act
        LocalDate actualDate = Task2.getNextFridayTheThirteenth(providedDate);

        // Assert
        assertEquals(expectedDate, actualDate);
    }

    private static Stream<Arguments> testGetNextFridayTheThirteenth_whenProvidedLocalDate_returnsLocalDate() {
        return Stream.of(
            Arguments.of(LocalDate.of(1925, 2, 13), LocalDate.of(1925, 3, 13)),
            Arguments.of(LocalDate.of(2024, 9, 13), LocalDate.of(2024, 12, 13))
        );
    }
}
