package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.Optional;

public class DateParserFromWordsAndNumbers extends DateAbstractParser {
    @Override
    public Optional<LocalDate> parseDate(String string) {
        if (string.contains("day ago") || string.contains("days ago")) {
            int daysAgo = Integer.parseInt(string.split(" ")[0]);
            LocalDate localDate = LocalDate.now().minusDays(daysAgo);
            return Optional.of(localDate);
        }
        return Optional.empty();
    }
}
