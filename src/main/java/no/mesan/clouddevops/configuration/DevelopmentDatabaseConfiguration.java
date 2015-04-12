package no.mesan.clouddevops.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class DevelopmentDatabaseConfiguration {

    @Bean
    public ServletRegistrationBean h2ServletRegistration() {
        final ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new WebServlet());
        servletRegistrationBean.addUrlMappings("/h2console/*");
        return servletRegistrationBean;
    }
}
