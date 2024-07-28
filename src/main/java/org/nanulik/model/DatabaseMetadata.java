package org.nanulik.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * @author Nane Petrosyan
 * 20.07.24
 */
public class DatabaseMetadata {
    private Map<String, DatabaseDetails> databases; // todo : map

    public DatabaseMetadata() {
    }

    public DatabaseMetadata(Map<String, DatabaseDetails> databases) {
        this.databases = databases;
    }

    public Map<String, DatabaseDetails> getDatabases() {
        return databases;
    }

    public void setDatabases(Map<String, DatabaseDetails> databases) {
        this.databases = databases;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(databases);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
