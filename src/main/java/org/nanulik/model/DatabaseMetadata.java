package org.nanulik.model;

import java.util.List;

/**
 * @author Nane Petrosyan
 * 20.07.24
 */
public class DatabaseMetadata {
    private List<DatabaseMapping> databases; // todo : map

    public DatabaseMetadata() {
    }

    public DatabaseMetadata(List<DatabaseMapping> databases) {
        this.databases = databases;
    }

    public List<DatabaseMapping> getDatabases() {
        return databases;
    }

    public void setDatabases(List<DatabaseMapping> databases) {
        this.databases = databases;
    }
}
