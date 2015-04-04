package no.mesan.clouddevops.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("production")
public class ProductionDatabaseDataSource {

    @Bean
    @Autowired
    public DataSource dataSource(ProductionDatabaseSettings settings) {
        return DataSourceBuilder.create()
                                .url(settings.getUrl())
                                .username(settings.getUsername())
                                .password(settings.getPasword())
                                .driverClassName(settings.getDriverClassName())
                                .build();
    }

    @Bean
    public ProductionDatabaseSettings productionDatabaseConfiguration() {
        return new ProductionDatabaseSettings();
    }
}
