package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Task1 {
    private static final int MINUTES_IN_HOUR = 60;

    private Task1() {
    }

    @SuppressWarnings("MultipleStringLiterals")
    public static String getSeveralDuration(String... inputLines) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        Duration duration = Duration.ZERO;
        int count = 0;
        for (String next : inputLines) {
            LocalDateTime time1 = LocalDateTime.parse(next.split(" - ")[0], formatter);
            LocalDateTime time2 = LocalDateTime.parse(next.split(" - ")[1], formatter);
            duration = duration.plus(Duration.between(time1, time2));
            count++;
        }
        duration = duration.dividedBy(count);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % MINUTES_IN_HOUR;

        return String.format("%dч %dм", hours, minutes);
    }
}
