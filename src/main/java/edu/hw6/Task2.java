package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class Task2 {

    private Task2() {
    }

    public static Path cloneFile(Path path) {
        int copyNumber = 0;
        Path newPath = path;
        while (Files.exists(newPath)) {
            String fileNamePrefix = path.getFileName().toString()
                .substring(0, path.getFileName().toString().lastIndexOf("."));
            String fileNameSuffix = path.getFileName().toString()
                .substring(path.getFileName().toString().lastIndexOf("."));
            String newFileName = fileNamePrefix + " - копия"
                + (copyNumber == 0 ? "" : " (" + copyNumber + ")") + fileNameSuffix;
            copyNumber++;
            newPath = Paths.get(path.getParent().toString(), newFileName);
        }
        try {
            Files.copy(path, newPath);
        } catch (IOException e) {
            throw new RuntimeException("File for copy not found");
        }

        return newPath;
    }
}
