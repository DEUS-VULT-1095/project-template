package edu.hw6;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.Checksum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Task4 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Task4.class);

    private Task4() {
    }

    public static void somePrint() {
        Checksum crc32 = new CRC32();
        try (
            OutputStream outputStream = Files
                .newOutputStream(Files.createFile(Paths.get("src", "main", "resources", "tempFile.txt")));
            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(outputStream, crc32);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                bufferedOutputStream, StandardCharsets.UTF_8
            );
            PrintWriter printWriter = new PrintWriter(outputStreamWriter)
        ) {
            printWriter.println("Programming is learned by writing programs. ― Brian Kernighan");
        } catch (IOException ex) {
            LOGGER.error("Error when trying to write into output stream");
            throw new RuntimeException(ex.getMessage());
        }
    }
}
