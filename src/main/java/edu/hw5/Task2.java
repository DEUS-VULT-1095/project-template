package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public final class Task2 {
    private static final int DAY = 13;

    private Task2() {
    }

    public static List<LocalDate> getFridayTheThirteenth(int year) {
        List<LocalDate> thirteenthFridaysDates = new ArrayList<>();

        for (Month month : Month.values()) {
            LocalDate currentDate = LocalDate.of(year, month, DAY);
            if (currentDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                thirteenthFridaysDates.add(currentDate);
            }
        }

        return thirteenthFridaysDates;
    }

    public static LocalDate getNextFridayTheThirteenth(LocalDate date) {
        LocalDate nextFriday13th = date.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while (nextFriday13th.getDayOfMonth() != DAY) {
            nextFriday13th = nextFriday13th.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }
        return nextFriday13th;
    }
}
