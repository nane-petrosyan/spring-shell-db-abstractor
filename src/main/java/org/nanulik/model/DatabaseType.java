package org.nanulik.model;

/**
 * @author Nane Petrosyan
 * 13.07.24
 */
public enum DatabaseType {
    POSTGRES("");

    private String databaseDriver;

    DatabaseType(String databaseDriver) {
        this.databaseDriver = databaseDriver;
    }

    public String getDatabaseDriver() {
        return databaseDriver;
    }
}
