package org.nanulik.service;

import jakarta.persistence.EntityManagerFactory;
import org.nanulik.configuration.DynamicDataSourceConfig;
import org.nanulik.model.DatabaseType;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author Nane Petrosyan
 * 15.07.24
 */

@Service
public class DynamicRepositoryService {
    private DynamicDataSourceConfig dynamicDataSourceConfig;
    private EntityManagerFactoryBuilder builder;

    private List<JpaRepository> registeredRepositories;

    public void connectToDatabase(String url, String username, String password, DatabaseType type) {
        DataSource dataSource = dynamicDataSourceConfig.createDataSource(url, username, password, type);
        EntityManagerFactory entityManagerFactory =
                dynamicDataSourceConfig.dynamicEntityManagerFactory(dataSource, builder).getObject();

        registeredRepositories.add(createRepository(entityManagerFactory));
    }

    private JpaRepository createRepository(EntityManagerFactory entityManagerFactory) {
        JpaRepositoryFactory factory = new JpaRepositoryFactory(entityManagerFactory.createEntityManager());
        return factory.getRepository(JpaRepository.class);
    }
}
