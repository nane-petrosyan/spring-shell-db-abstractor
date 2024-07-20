package org.nanulik.service;

import org.nanulik.helper.MetadataSaver;
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
    private final MetadataSaver metadataSaver;
    private final DatabaseMetadata databaseMetadata;

    public DatabaseService(MetadataSaver metadataSaver) {
        this.metadataSaver = metadataSaver;
        this.databaseMetadata = null; // todo
    }

    public DatabaseMetadata readDatabases() {
        return metadataSaver.readDatabaseMetadata();
    }

    public void addDatabaseMapping(final String url, final String alias, final DatabaseType type) {
        databaseMetadata.getDatabases().add(new DatabaseMapping(alias, new DatabaseDetails(type, url))); // todo

        metadataSaver.persistDatabaseMetadata( // todo
                databaseMetadata
        );
    }

    public void removeDatabaseMapping(final String alias) {
        // todo

        metadataSaver.persistDatabaseMetadata(
                databaseMetadata
        );
    }
}
