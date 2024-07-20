package org.nanulik.model;

/**
 * @author Nane Petrosyan
 * 15.07.24
 */
public class DatabaseMapping {
    private String alias;
    private DatabaseDetails details;

    public DatabaseMapping(String alias, DatabaseDetails details) {
        this.alias = alias;
        this.details = details;
    }

    public String getAlias() {
        return alias;
    }

    public DatabaseDetails getDetails() {
        return details;
    }
}
