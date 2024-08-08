package org.nanulik.service;

import jakarta.persistence.EntityManagerFactory;
import org.nanulik.configuration.DynamicDataSourceConfig;
import org.nanulik.model.DatabaseConnectionDescription;
import org.nanulik.model.DatabaseType;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nane Petrosyan
 * 15.07.24
 */

@Service
public class DynamicRepositoryService {
    private DynamicDataSourceConfig dynamicDataSourceConfig;
    private EntityManagerFactoryBuilder builder;

    private Map<String, JpaRepository> repositoryMap = new HashMap<>();

    private JpaRepository connectToDatabase(final DatabaseConnectionDescription databaseConnectionDescription) {
        DataSource dataSource = dynamicDataSourceConfig.createDataSource
                (
                        databaseConnectionDescription.getUrl(),
                        databaseConnectionDescription.getUsername(),
                        databaseConnectionDescription.getPassword(),
                        databaseConnectionDescription.getType()
                );

        EntityManagerFactory entityManagerFactory =
                dynamicDataSourceConfig.dynamicEntityManagerFactory(dataSource, builder).getObject();

        return createRepository(entityManagerFactory);
    }

    public JpaRepository fetchRepository(final DatabaseConnectionDescription connectionDescription) {
        if (!repositoryMap.containsKey(connectionDescription.getUrl())) {
            final JpaRepository repository = connectToDatabase(connectionDescription);
            repositoryMap.put(connectionDescription.getUrl(), repository);
        }

        return repositoryMap.get(connectionDescription.getUrl());
    }

    private JpaRepository createRepository(EntityManagerFactory entityManagerFactory) {
        JpaRepositoryFactory factory = new JpaRepositoryFactory(entityManagerFactory.createEntityManager());
        return factory.getRepository(JpaRepository.class);
    }
}
