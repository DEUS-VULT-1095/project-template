package edu.hw3;

import java.util.Comparator;
import java.util.List;

public final class Task5 {

    private Task5() {
    }

    public static List<String> parseContacts(List<String> contactList, String sortOrder) {
        switch (sortOrder) {
            case "ASC" -> {
                return contactList.stream()
                    .sorted(Comparator
                        .comparing(contact -> contact.split(" ").length == 2 ? contact.split(" ")[1] : contact))
                    .toList();
            }
            case "DESC" -> {
                return contactList.stream()
                    .sorted(Comparator
                        .comparing(contact -> contact.split(" ").length == 2 ? contact.split(" ")[1] : contact))
                    .toList()
                    .reversed();
            }
            default -> throw new RuntimeException("Wrong sort type");
        }
    }
}
