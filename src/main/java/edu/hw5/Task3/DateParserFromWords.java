package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DateParserFromWords extends DateAbstractParser {
    @Override
    public Optional<LocalDate> parseDate(String string) {
        Map<String, LocalDate> map = new HashMap<>();
        map.put("tomorrow", LocalDate.now().plusDays(1));
        map.put("today", LocalDate.now());
        map.put("yesterday", LocalDate.now().minusDays(1));

        for (Map.Entry<String, LocalDate> next : map.entrySet()) {
            if (string.equals(next.getKey())) {
                return Optional.of(next.getValue());
            }
        }
        return Optional.empty();
    }
}
