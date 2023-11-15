package edu.hw6;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("MultipleStringLiterals")
public final class Task6 {
    private static final int NUMBER_PORTS = 49151;
    private static final String CSV_FILE = Objects.requireNonNull(Task6.class.getResource(
        "/service-names-port-numbers.csv")).getPath();
    private static final Map<Integer, String> PORTS_MAP = new HashMap<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(Task6.class);
    private static final int NUMBER_OF_COLUMN_1 = 1;
    private static final int NUMBER_OF_COLUMN_3 = 3;
    private static final int NUMBER_FOR_PRINT_CORRECT = 999;
    private static final String UNKNOWN_RESOURCE = "unknown";

    private Task6() {
    }

    public static String getBusyPorts() {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            reader.readNext();

            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                try {
                    int port = Integer.parseInt(nextLine[NUMBER_OF_COLUMN_1]);
                    String description = nextLine[NUMBER_OF_COLUMN_3].trim();

                    PORTS_MAP.put(port, description);
                } catch (NumberFormatException ex) {
                    continue;
                }
            }
        } catch (IOException ex) {
            LOGGER.error("Error when trying read .csv file");
        } catch (CsvValidationException e) {
            LOGGER.error("Error CSV validation");
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Протокол\tПорт\tСервис\n");
        for (int i = 0; i < NUMBER_PORTS; i++) {
            checkTCPPort(i, sb);
            checkUDPPort(i, sb);
        }

        return sb.toString();
    }

    private static void checkUDPPort(int port, StringBuilder sb) {
        try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
            // do nothing
        } catch (IOException ex) {
            sb.append("UDP\t\t\t" + port + (port > NUMBER_FOR_PRINT_CORRECT ? "\t" : "\t\t")
                + (PORTS_MAP.get(port) == null ? UNKNOWN_RESOURCE : PORTS_MAP.get(port)) + "\n");
        }
    }

    private static void checkTCPPort(int port, StringBuilder sb) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // do nothing
        } catch (IOException ex) {
            sb.append("TCP\t\t\t" + port + (port > NUMBER_FOR_PRINT_CORRECT ? "\t" : "\t\t")
                + (PORTS_MAP.get(port) == null ? UNKNOWN_RESOURCE : PORTS_MAP.get(port)) + "\n");
        }
    }
}
