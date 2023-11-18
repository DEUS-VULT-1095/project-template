package edu.hw6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiskMap implements Map<String, String> {
    private static final Logger LOGGER = LoggerFactory.getLogger(DiskMap.class);
    private final String filePath;
    private final Map<String, String> inMemoryMap;

    public DiskMap(String filePath) {
        this.filePath = filePath;
        Path path = Paths.get(filePath);
        this.inMemoryMap = new HashMap<>();
        if (new File(filePath).exists()) {
            loadFromFile();
        } else {
            try {
                Files.createDirectories(path.getParent());
                Files.createFile(path);
            } catch (IOException e) {
                LOGGER.error("error when trying create file");
                throw new RuntimeException(e);
            }
        }
    }

    private void loadFromFile() {
        inMemoryMap.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    inMemoryMap.put(parts[0], parts[1]);
                }
            }
        } catch (IOException ex) {
            LOGGER.error("error when trying load from file");
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : inMemoryMap.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException ex) {
            LOGGER.error("error when trying save to file");
        }
    }

    private void addToFile(String key, String value) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(key + ":" + value);
            writer.newLine();
        } catch (IOException ex) {
            LOGGER.error("error when trying add to file");
        }
    }

    @Override
    public int size() {
        loadFromFile();
        return inMemoryMap.size();
    }

    @Override
    public boolean isEmpty() {
        loadFromFile();
        return inMemoryMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        loadFromFile();
        return inMemoryMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        loadFromFile();
        return inMemoryMap.containsValue(value);
    }

    @Override
    public String get(Object key) {
        loadFromFile();
        return inMemoryMap.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        loadFromFile();
        String oldValue = inMemoryMap.put(key, value);
        if (oldValue == null) {
            addToFile(key, value);
        } else {
            saveToFile();
        }
        return oldValue;
    }

    @Override
    public String remove(Object key) {
        loadFromFile();
        String removeValue = inMemoryMap.remove(key);
        saveToFile();
        return removeValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        loadFromFile();
        inMemoryMap.putAll(m);
        saveToFile();
    }

    @Override
    public void clear() {
        inMemoryMap.clear();
        saveToFile();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        loadFromFile();
        return inMemoryMap.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        loadFromFile();
        return inMemoryMap.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        loadFromFile();
        return inMemoryMap.entrySet();
    }
}
