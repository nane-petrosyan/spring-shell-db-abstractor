package org.nanulik.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nanulik.model.DatabaseMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
}
