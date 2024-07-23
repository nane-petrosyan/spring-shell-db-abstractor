package org.nanulik.service;

import org.nanulik.model.DatabaseDetails;
import org.nanulik.model.DatabaseMetadata;
import org.nanulik.model.DatabaseType;
import org.springframework.stereotype.Service;

/**
 * @author Nane Petrosyan
 * 20.07.24
 */

@Service
public class DatabaseService {
    private final DatabaseMetadata databaseMetadata;

    public DatabaseService(DatabaseMetadata databaseMetadata) {
        this.databaseMetadata = databaseMetadata;
    }

    public DatabaseMetadata readDatabases() {
        return databaseMetadata;
    }

    public void addDatabaseMapping(final String url, final String alias, final DatabaseType type) {
        databaseMetadata.getDatabases().put(alias, new DatabaseDetails(type, url));
    }

    public void removeDatabaseMapping(final String alias) {
        // todo
    }
}
