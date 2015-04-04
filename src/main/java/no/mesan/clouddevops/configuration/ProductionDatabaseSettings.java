package no.mesan.clouddevops.configuration;

import org.springframework.beans.factory.annotation.Value;

public class ProductionDatabaseSettings {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String pasword;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPasword() {
        return pasword;
    }

    public String getDriverClassName() {
        return driverClassName;
    }
}
