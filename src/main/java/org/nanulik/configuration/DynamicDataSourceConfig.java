package org.nanulik.configuration;

import org.nanulik.model.DatabaseType;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * @author Nane Petrosyan
 * 15.07.24
 */
@Configuration
public class DynamicDataSourceConfig {

    @Bean
    @Scope("prototype")
    public DataSource createDataSource(
            String url,
            String username,
            String password,
            DatabaseType type
    ) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(type.getDatabaseDriver());
        return dataSource;
    }


    @Bean
    @Scope("prototype")
    public LocalContainerEntityManagerFactoryBean dynamicEntityManagerFactory(
            DataSource dataSource,
            EntityManagerFactoryBuilder builder
    ) {
        return builder
                .dataSource(dataSource)
                .build();
    }

}