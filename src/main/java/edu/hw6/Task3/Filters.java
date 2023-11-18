package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.Files;

public final class Filters {

    private Filters() {
    }

    public static final int MASK = 0xFF;
    public static final AbstractFilter REGULAR_FILE = Files::isRegularFile;
    public static final AbstractFilter READABLE = Files::isReadable;
    public static final AbstractFilter WRITABLE = Files::isWritable;

    public static AbstractFilter fileSize(int minSize, int maxSize) {
        return path -> Files.size(path) >= minSize && Files.size(path) <= maxSize;
    }

    public static AbstractFilter extension(String extension) {
        return path -> path.getFileName().toString().toLowerCase().endsWith(extension.toLowerCase());
    }

    public static AbstractFilter regexMatches(String regex) {
        return path -> path.getFileName().toString().matches(regex);
    }

    public static AbstractFilter magicNumber(int... magicBytes) {
        return path -> {
            try {
                byte[] fileBytes = Files.readAllBytes(path);
                if (fileBytes.length < magicBytes.length) {
                    return false;
                }

                for (int i = 0; i < magicBytes.length; i++) {
                    if ((fileBytes[i] & MASK) != magicBytes[i]) {
                        return false;
                    }
                }
                return true;
            } catch (IOException ex) {
                return false;
            }
        };
    }
}
