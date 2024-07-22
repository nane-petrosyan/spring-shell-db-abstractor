package org.nanulik.service;

import org.nanulik.model.DatabaseDetails;
import org.nanulik.model.DatabaseMapping;
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
        databaseMetadata.getDatabases().add(new DatabaseMapping(alias, new DatabaseDetails(type, url))); // todo
    }

    public void removeDatabaseMapping(final String alias) {
        // todo
    }
}
