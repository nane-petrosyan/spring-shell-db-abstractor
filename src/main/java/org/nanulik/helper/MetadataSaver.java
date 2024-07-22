package org.nanulik.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nanulik.model.DatabaseMetadata;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Nane Petrosyan
 * 20.07.24
 */

public class MetadataSaver {

    @Value("${persistor.file.path}")
    private String fileName;

    private final ObjectMapper objectMapper;

    public MetadataSaver() {
        this.objectMapper = new ObjectMapper();
    }

    public DatabaseMetadata readDatabaseMetadata() {
        try(final FileInputStream file = new FileInputStream(fileName)) {
            return objectMapper.readValue(file, DatabaseMetadata.class);
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void persistDatabaseMetadata(final DatabaseMetadata databaseMetadata) {
        try(final FileOutputStream file = new FileOutputStream(fileName)) {
            objectMapper.writeValue(file, DatabaseMetadata.class);
        } catch (final IOException e) {
            // throw another exception
        }
    }

    @PostConstruct
    private void prepareMetadataSpace() {
        final File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("Creating metadata space.");
            try {
                Files.createFile(Paths.get(fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (FileWriter writer = new FileWriter(fileName)) {
                objectMapper.writeValue(writer, new DatabaseMetadata(List.of()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
