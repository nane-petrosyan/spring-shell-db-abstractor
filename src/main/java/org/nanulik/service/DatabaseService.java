package org.nanulik.service;

import org.nanulik.helper.MetadataSaver;
import org.nanulik.model.DatabaseMetadata;
import org.springframework.stereotype.Service;

/**
 * @author Nane Petrosyan
 * 20.07.24
 */

@Service
public class DatabaseService {
    private MetadataSaver metadataSaver;

    public DatabaseService(MetadataSaver metadataSaver) {
        this.metadataSaver = metadataSaver;
    }

    public DatabaseMetadata readDatabases() {
        return metadataSaver.readDatabaseMetadata();
    }
}
