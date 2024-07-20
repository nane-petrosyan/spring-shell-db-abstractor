package org.nanulik.configuration;

import org.nanulik.helper.MetadataSaver;
import org.nanulik.model.DatabaseMetadata;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Nane Petrosyan
 * 20.07.24
 */

@Component
public class PersistorConfig {
    private final MetadataSaver metadataSaver;

    public PersistorConfig(MetadataSaver metadataSaver) {
        this.metadataSaver = metadataSaver;
    }

    @Bean
    public DatabaseMetadata databaseMetadata() {
        return metadataSaver.readDatabaseMetadata();
    }
}
