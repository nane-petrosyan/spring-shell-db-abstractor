package org.nanulik.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nanulik.helper.MetadataSaver;
import org.nanulik.model.DatabaseMetadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nane Petrosyan
 * 20.07.24
 */

@Configuration
public class PersistorConfig {

    @Bean
    public MetadataSaver metadataSaver() {
        return new MetadataSaver();
    }

    @Bean
    public DatabaseMetadata databaseMetadata() {
        return metadataSaver().readDatabaseMetadata();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
