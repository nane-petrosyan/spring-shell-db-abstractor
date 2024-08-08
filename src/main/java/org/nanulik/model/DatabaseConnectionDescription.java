package org.nanulik.model;

/**
 * @author Nane Petrosyan
 * 07.08.24
 */
public class DatabaseConnectionDescription {
    private String url;
    private String password;
    private String username;
    private DatabaseType type;

    public DatabaseConnectionDescription() {

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DatabaseType getType() {
        return type;
    }

    public void setType(DatabaseType type) {
        this.type = type;
    }
}
