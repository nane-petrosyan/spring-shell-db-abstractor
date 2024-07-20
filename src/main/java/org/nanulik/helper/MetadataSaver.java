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

@Component
public class MetadataSaver {

    @Value("{}")
    private String fileName;

    private final ObjectMapper objectMapper;

    public MetadataSaver(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public DatabaseMetadata readDatabaseMetadata() {
        try(final FileInputStream file = new FileInputStream(fileName)) {
            return objectMapper.readValue(file, DatabaseMetadata.class);
        } catch (final IOException e) {
            // throw another exception
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
