package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class DateParserFromNumbers extends DateAbstractParser {
    @Override
    public Optional<LocalDate> parseDate(String string) {
        DateTimeFormatter[] formatters = {
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("yyyy-MM-d"),
            DateTimeFormatter.ofPattern("d/M/yyyy"),
            DateTimeFormatter.ofPattern("d/M/yy")
        };

        for (DateTimeFormatter formatter : formatters) {
            LocalDate date;
            try {
                date = LocalDate.parse(string, formatter);
            } catch (Exception ex) {
                continue;
            }
            return Optional.of(date);
        }
        return Optional.empty();
    }
}
