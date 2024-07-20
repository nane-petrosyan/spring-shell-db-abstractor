package org.nanulik.model;

/**
 * @author Nane Petrosyan
 * 15.07.24
 */
public class DatabaseDetails {
    private DatabaseType type;
    private String url;

    public DatabaseDetails(DatabaseType type, String url) {
        this.type = type;
        this.url = url;
    }

    public DatabaseType getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}
